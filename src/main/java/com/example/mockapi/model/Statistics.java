package com.example.mockapi.model;

public class Statistics {
    private Integer totalCustomers;
    private Integer totalOrders;
    private Double totalRevenue;

    public Integer getTotalCustomers() {
        return totalCustomers;
    }
    public void setTotalCustomers(Integer totalCustomers) {
        this.totalCustomers = totalCustomers;
    }
    public Integer getTotalOrders() {
        return totalOrders;
    }
    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }
    public Double getTotalRevenue() {
        return totalRevenue;
    }
    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
} 