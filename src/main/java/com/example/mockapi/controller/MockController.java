package com.example.mockapi.controller;

import com.example.mockapi.model.Customer;
import com.example.mockapi.model.Order;
import com.example.mockapi.model.Product;
import com.example.mockapi.model.Statistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MockController {

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Max Mustermann");
        customer.setEmail("max@example.com");
        customer.setAddress("Musterstraße 123, 12345 Berlin");
        return customer;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = new Order();
        order.setId(id);
        order.setCustomerId(1L);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(99.99);
        order.setStatus("DELIVERED");
        return order;
    }

    @GetMapping("/customers/{id}/orders")
    public List<Order> getOrders(@PathVariable Long id) {
        return Arrays.asList(
            Order.createOrder(1L, id, LocalDateTime.now(), 99.99, "DELIVERED"),
            Order.createOrder(2L, id, LocalDateTime.now(), 199.99, "SHIPPED"),
            Order.createOrder(3L, id, LocalDateTime.now(), 299.99, "PENDING")
        );
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Test Produkt");
        product.setPrice(149.99);
        product.setCategory("Elektronik");
        return product;
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return Arrays.asList("Elektronik", "Bücher", "Kleidung", "Sport", "Haushalt");
    }

    @GetMapping("/statistics")
    public Statistics getStatistics() {
        Statistics stats = new Statistics();
        stats.setTotalCustomers(1000);
        stats.setTotalOrders(5000);
        stats.setTotalRevenue(250000.00);
        return stats;
    }
} 