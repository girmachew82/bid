package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order addOrder(Order order, int customerId);
}
