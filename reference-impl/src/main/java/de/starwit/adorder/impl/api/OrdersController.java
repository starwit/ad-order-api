package de.starwit.adorder.impl.api;

import de.starwit.adorder.impl.service.OrderService;
import de.starwit.adorder.model.RideOrder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<RideOrder> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        RideOrder created = orderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<OrderList> listOrders(
            @RequestParam(required = false) OrderStatus status,
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return ResponseEntity.ok(orderService.list(status, limit, offset));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<RideOrder> getOrder(@PathVariable UUID orderId) {
        return ResponseEntity.ok(orderService.getById(orderId));
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<RideOrder> updateOrder(
            @PathVariable UUID orderId,
            @Valid @RequestBody UpdateOrderRequest request) {
        return ResponseEntity.ok(orderService.update(orderId, request));
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<RideOrder> cancelOrder(
            @PathVariable UUID orderId,
            @RequestBody(required = false) CancelOrderRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(orderService.cancel(orderId, request));
    }
}
