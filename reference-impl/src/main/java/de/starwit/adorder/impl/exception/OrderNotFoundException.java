package de.starwit.adorder.impl.exception;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID orderId) {
        super("No order found with id: " + orderId);
    }
}
