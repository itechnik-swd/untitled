package org.util;

import java.time.LocalTime;

public class Order {
    private String orderId;
    private LocalTime createdAt;

    public Order(String orderId, LocalTime createdAt) {
        this.orderId = orderId;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }
}
