package com.example.bid.controller;

import java.util.List;

import com.example.bid.model.Order;
import com.example.bid.service.CustomerServiceImp;
import com.example.bid.service.OrderServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;

    @Autowired
    private CustomerServiceImp customerServiceImp;

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderServiceImp.getAllOrders();
    }
    // Insert order record
    @PostMapping("/add/customer/{customerId}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addOrder(@RequestBody Order order, @PathVariable("customerId") int customerId) {

        return orderServiceImp.addOrder(order, customerId);
        // return order;
    }

    @GetMapping("/getByOrderType/{type}")
    public List<Order> getByOrderType(@PathVariable("type") String type) {
        return orderServiceImp.getOrderByType(type);
    }

    @GetMapping("/getByCustomerId/{customerId}")
    public List<Order> getByCustomerId(@PathVariable("customerId") int customerId) {
        return orderServiceImp.getByCustomerId(customerId);
    }
    @GetMapping("/getById/{orderId}")
    public Order getById(@PathVariable("orderId") int orderId) {
        return orderServiceImp.getById(orderId);
    }
}