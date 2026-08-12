package de.starwit.adorder.impl.config;

import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.outbound.Mqttv5PahoMessageHandler;

/**
 * MQTT configuration for Spring Boot 4.
 * Uses the MQTTv5 Paho client (org.eclipse.paho.mqttv5.client),
 * replacing the deprecated MQTTv3 client used in Spring Boot 3.
 */
@Configuration
public class MqttConfig {

    @Value("${mqtt.broker-url}")
    private String brokerUrl;

    @Value("${mqtt.client-id}")
    private String clientId;

    @Value("${mqtt.qos}")
    private int qos;

    @Bean
    public Mqttv5PahoMessageHandler mqttOutboundHandler() {
        MqttConnectionOptions options = new MqttConnectionOptions();
        options.setServerURIs(new String[]{brokerUrl});
        options.setCleanStartSession(false);
        options.setAutomaticReconnect(true);
        options.setConnectionTimeout(10);
        options.setKeepAliveInterval(30);

        Mqttv5PahoMessageHandler handler =
                new Mqttv5PahoMessageHandler(brokerUrl, clientId + "-pub");
        handler.setConnectionOptions(options);
        handler.setAsync(true);
        handler.setDefaultQos(qos);
        handler.setDefaultRetained(true);
        return handler;
    }
}
