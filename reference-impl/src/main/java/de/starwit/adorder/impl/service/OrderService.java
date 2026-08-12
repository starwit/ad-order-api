package de.starwit.adorder.impl.service;

import de.starwit.adorder.exception.OrderConflictException;
import de.starwit.adorder.exception.OrderNotFoundException;
import de.starwit.adorder.model.*;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * In-memory order store. Replace with persistent storage for production use.
 * Publishes order state changes via the supplied listener (MqttPublisher).
 */
@Service
public class OrderService {

    private static final Set<OrderStatus> ACTIVE_STATUSES = Set.of(
            OrderStatus.PENDING, OrderStatus.ACCEPTED, OrderStatus.IN_PROGRESS);

    private static final Set<OrderStatus> TERMINAL_STATUSES = Set.of(
            OrderStatus.COMPLETED, OrderStatus.CANCELLED, OrderStatus.FAILED, OrderStatus.REJECTED);

    private final Map<UUID, RideOrder> orders = new ConcurrentHashMap<>();
    private final List<OrderChangeListener> listeners = new ArrayList<>();

    public interface OrderChangeListener {
        void onOrderChanged(RideOrder order);
    }

    public void addListener(OrderChangeListener listener) {
        listeners.add(listener);
    }

    // -------------------------------------------------------------------------
    // Create
    // -------------------------------------------------------------------------

    public RideOrder create(CreateOrderRequest request) {
        // Only one active order at a time
        boolean hasActive = orders.values().stream()
                .anyMatch(o -> ACTIVE_STATUSES.contains(o.getStatus()));
        if (hasActive) {
            throw new OrderConflictException(
                    "An active order already exists. Cancel it before creating a new one.");
        }

        RideOrder order = new RideOrder();
        order.setOrderId(UUID.randomUUID());
        order.setClientOrderId(request.getClientOrderId());
        order.setSource(request.getSource());
        order.setStops(assignStopIds(request.getStops()));
        order.setPriority(request.getPriority() != null
                ? RideOrder.PriorityEnum.fromValue(request.getPriority().getValue())
                : RideOrder.PriorityEnum.NORMAL);
        order.setConstraints(request.getConstraints());
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(OffsetDateTime.now());

        // Simulate immediate AD stack acceptance
        order.setStatus(OrderStatus.ACCEPTED);
        order.setAcceptedAt(OffsetDateTime.now());

        orders.put(order.getOrderId(), order);
        notifyListeners(order);
        return order;
    }

    // -------------------------------------------------------------------------
    // Read
    // -------------------------------------------------------------------------

    public RideOrder getById(UUID orderId) {
        RideOrder order = orders.get(orderId);
        if (order == null) {
            throw new OrderNotFoundException(orderId);
        }
        return order;
    }

    public OrderList list(OrderStatus statusFilter, int limit, int offset) {
        List<RideOrder> filtered = orders.values().stream()
                .filter(o -> statusFilter == null || o.getStatus() == statusFilter)
                .sorted(Comparator.comparing(RideOrder::getCreatedAt).reversed())
                .collect(Collectors.toList());

        int total = filtered.size();
        List<RideOrder> page = filtered.stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

        OrderList result = new OrderList();
        result.setItems(page);
        result.setTotal(total);
        return result;
    }

    public List<RideOrder> getAllNonTerminal() {
        return orders.values().stream()
                .filter(o -> !TERMINAL_STATUSES.contains(o.getStatus()))
                .collect(Collectors.toList());
    }

    // -------------------------------------------------------------------------
    // Update
    // -------------------------------------------------------------------------

    public RideOrder update(UUID orderId, UpdateOrderRequest request) {
        RideOrder order = getById(orderId);

        if (TERMINAL_STATUSES.contains(order.getStatus())) {
            throw new OrderConflictException(
                    "Order " + orderId + " is in terminal state " + order.getStatus() + " and cannot be updated.");
        }

        if (request.getStops() != null) {
            if (order.getStatus() == OrderStatus.IN_PROGRESS) {
                // For in_progress: only allow appending stops with higher sequence numbers
                int maxExisting = order.getStops().stream()
                        .filter(s -> s.getSequenceNumber() != null)
                        .mapToInt(Stop::getSequenceNumber)
                        .max()
                        .orElse(-1);
                boolean allHigher = request.getStops().stream()
                        .filter(s -> s.getSequenceNumber() != null)
                        .allMatch(s -> s.getSequenceNumber() > maxExisting);
                if (!allHigher) {
                    throw new OrderConflictException(
                            "For in_progress orders only stops with higher sequence numbers may be added.");
                }
                List<Stop> combined = new ArrayList<>(order.getStops());
                combined.addAll(assignStopIds(request.getStops()));
                order.setStops(combined);
            } else {
                order.setStops(assignStopIds(request.getStops()));
            }
        }

        if (request.getPriority() != null) {
            if (order.getStatus() == OrderStatus.IN_PROGRESS) {
                throw new OrderConflictException("Priority cannot be changed while order is in_progress.");
            }
            order.setPriority(RideOrder.PriorityEnum.fromValue(request.getPriority().getValue()));
        }

        if (request.getConstraints() != null) {
            order.setConstraints(request.getConstraints());
        }

        notifyListeners(order);
        return order;
    }

    // -------------------------------------------------------------------------
    // Cancel
    // -------------------------------------------------------------------------

    public RideOrder cancel(UUID orderId, CancelOrderRequest request) {
        RideOrder order = getById(orderId);

        if (TERMINAL_STATUSES.contains(order.getStatus())) {
            throw new OrderConflictException(
                    "Order " + orderId + " is already in terminal state " + order.getStatus());
        }

        // Transition asynchronously to cancelled; for the reference impl we do it immediately
        order.setStatus(OrderStatus.CANCELLED);
        order.setCompletedAt(OffsetDateTime.now());
        if (request != null && request.getReason() != null) {
            order.setStatusDetail("Cancelled: " + request.getReason());
        }

        notifyListeners(order);
        return order;
    }

    // -------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------

    private List<Stop> assignStopIds(List<Stop> stops) {
        if (stops == null) return Collections.emptyList();
        stops.forEach(s -> {
            if (s.getStopId() == null) {
                s.setStopId(UUID.randomUUID());
            }
        });
        return stops;
    }

    private void notifyListeners(RideOrder order) {
        listeners.forEach(l -> l.onOrderChanged(order));
    }
}
