package de.starwit.adorder.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.starwit.adorder.impl.api.OrdersController;
import de.starwit.adorder.impl.exception.GlobalExceptionHandler;
import de.starwit.adorder.impl.service.OrderService;
import de.starwit.adorder.impl.service.VehicleStateService;
import de.starwit.adorder.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrdersController.class)
@Import(GlobalExceptionHandler.class)
class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // @MockitoBean replaces the removed @MockBean in Spring Boot 4
    @MockitoBean
    private OrderService orderService;

    @MockitoBean
    private VehicleStateService vehicleStateService;

    private RideOrder sampleOrder;

    @BeforeEach
    void setUp() {
        GeoPoint location = new GeoPoint();
        location.setLatitude(52.4226);
        location.setLongitude(10.7865);

        Stop stop = new Stop();
        stop.setStopId(UUID.randomUUID());
        stop.setLocation(location);
        stop.setStatus(Stop.StatusEnum.PENDING);

        OrderSource source = new OrderSource();
        source.setType(OrderSource.TypeEnum.BACKEND);
        source.setId("test-backend");

        sampleOrder = new RideOrder();
        sampleOrder.setOrderId(UUID.randomUUID());
        sampleOrder.setSource(source);
        sampleOrder.setStops(List.of(stop));
        sampleOrder.setStatus(OrderStatus.ACCEPTED);
        sampleOrder.setPriority(RideOrder.PriorityEnum.NORMAL);
        sampleOrder.setCreatedAt(OffsetDateTime.now());
        sampleOrder.setAcceptedAt(OffsetDateTime.now());
    }

    @Test
    void createOrder_returnsCreated() throws Exception {
        when(orderService.create(any())).thenReturn(sampleOrder);

        GeoPoint loc = new GeoPoint();
        loc.setLatitude(52.4226);
        loc.setLongitude(10.7865);

        Stop stop = new Stop();
        stop.setLocation(loc);

        OrderSource source = new OrderSource();
        source.setType(OrderSource.TypeEnum.BACKEND);
        source.setId("test");

        CreateOrderRequest req = new CreateOrderRequest();
        req.setSource(source);
        req.setStops(List.of(stop));

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("accepted"));
    }

    @Test
    void getOrder_returnsOrder() throws Exception {
        when(orderService.getById(sampleOrder.getOrderId())).thenReturn(sampleOrder);

        mockMvc.perform(get("/orders/{id}", sampleOrder.getOrderId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").value(sampleOrder.getOrderId().toString()));
    }

    @Test
    void listOrders_returnsList() throws Exception {
        OrderList orderList = new OrderList();
        orderList.setItems(List.of(sampleOrder));
        orderList.setTotal(1);
        when(orderService.list(any(), any(Integer.class), any(Integer.class))).thenReturn(orderList);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(1))
                .andExpect(jsonPath("$.items[0].status").value("accepted"));
    }

    @Test
    void getOrder_notFound_returns404() throws Exception {
        UUID unknownId = UUID.randomUUID();
        when(orderService.getById(unknownId))
                .thenThrow(new de.starwit.adorder.exception.OrderNotFoundException(unknownId));

        mockMvc.perform(get("/orders/{id}", unknownId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("ORDER_NOT_FOUND"));
    }

    @Test
    void cancelOrder_conflict_returns409() throws Exception {
        when(orderService.cancel(any(), any()))
                .thenThrow(new de.starwit.adorder.exception.OrderConflictException(
                        "Order is already in a terminal state"));

        mockMvc.perform(post("/orders/{id}/cancel", sampleOrder.getOrderId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.code").value("ORDER_CONFLICT"));
    }
}
