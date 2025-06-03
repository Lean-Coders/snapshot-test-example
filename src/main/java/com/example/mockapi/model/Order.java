package com.example.mockapi.model;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private Long customerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public static Order createOrder(Long id, Long customerId, LocalDateTime orderDate, Double totalAmount, String status) {
        Order order = new Order();
        order.setId(id);
        order.setCustomerId(customerId);
        order.setOrderDate(orderDate);
        order.setTotalAmount(totalAmount);
        order.setStatus(status);
        return order;
    }
} 