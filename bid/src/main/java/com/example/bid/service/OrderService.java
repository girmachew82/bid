package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Customer;
import com.example.bid.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order addOrder(Order order, int customerId);
    List<Order> getOrderByType(String status);
    List<Order> getByCustomerId(int customerId);
    Order getById(int orderId);

}
