package de.starwit.adorder.impl.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.starwit.adorder.impl.service.OrderService;
import de.starwit.adorder.impl.service.VehicleStateService;
import de.starwit.adorder.model.RideOrder;
import de.starwit.adorder.model.VehicleStatus;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.mqtt.outbound.Mqttv5PahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Publishes to MQTT topics using the MQTTv5 Paho client:
 *   /vehicle/status  - periodic heartbeat + on-demand
 *   /vehicle/orders  - on every order state change + periodic heartbeat
 */
@Component
public class MqttPublisher implements OrderService.OrderChangeListener {

    private static final Logger log = LoggerFactory.getLogger(MqttPublisher.class);

    private final Mqttv5PahoMessageHandler mqttHandler;
    private final VehicleStateService vehicleStateService;
    private final OrderService orderService;
    private final ObjectMapper objectMapper;

    @Value("${mqtt.topic.vehicle-status}")
    private String statusTopic;

    @Value("${mqtt.topic.vehicle-orders}")
    private String ordersTopic;

    @Value("${mqtt.qos}")
    private int qos;

    public MqttPublisher(Mqttv5PahoMessageHandler mqttHandler,
                         VehicleStateService vehicleStateService,
                         OrderService orderService,
                         ObjectMapper objectMapper) {
        this.mqttHandler = mqttHandler;
        this.vehicleStateService = vehicleStateService;
        this.orderService = orderService;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        orderService.addListener(this);
    }

    // -------------------------------------------------------------------------
    // Periodic publish (heartbeat)
    // -------------------------------------------------------------------------

    @Scheduled(fixedDelayString = "${mqtt.publish-interval-ms}")
    public void publishStatusHeartbeat() {
        publishVehicleStatus(vehicleStateService.getCurrentStatus());
    }

    @Scheduled(fixedDelayString = "${mqtt.publish-interval-ms}")
    public void publishOrdersHeartbeat() {
        publishVehicleOrders(orderService.getAllNonTerminal());
    }

    // -------------------------------------------------------------------------
    // Event-driven publish (order changes)
    // -------------------------------------------------------------------------

    @Override
    public void onOrderChanged(RideOrder order) {
        publishVehicleOrders(orderService.getAllNonTerminal());
    }

    // -------------------------------------------------------------------------
    // Publish helpers
    // -------------------------------------------------------------------------

    public void publishVehicleStatus(VehicleStatus status) {
        publish(statusTopic, Map.of("status", status));
    }

    public void publishVehicleOrders(List<RideOrder> orders) {
        publish(ordersTopic, Map.of("orders", orders));
    }

    private void publish(String topic, Object payload) {
        try {
            String json = objectMapper.writeValueAsString(payload);
            Message<String> message = MessageBuilder.withPayload(json)
                    .setHeader(MqttHeaders.TOPIC, topic)
                    .setHeader(MqttHeaders.QOS, qos)
                    .setHeader(MqttHeaders.RETAINED, true)
                    .build();
            mqttHandler.handleMessage(message);
            log.debug("Published to {}: {} chars", topic, json.length());
        } catch (MessageHandlingException e) {
            // Broker not available — log and continue; retried on next heartbeat
            log.warn("MQTT broker unavailable, could not publish to {}: {}", topic, e.getMessage());
        } catch (Exception e) {
            log.error("Failed to publish to topic {}", topic, e);
        }
    }
}
