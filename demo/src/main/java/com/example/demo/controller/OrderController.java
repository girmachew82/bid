package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.service.CustomerServiceImp;
import com.example.demo.service.OrderServiceImp;

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
//@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;

    @Autowired
    private CustomerServiceImp customerServiceImp;


    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        
        return orderServiceImp.getAllOrders();
    }
    
    //Insert order record
    @PostMapping("customer/{customerId}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addOrder(@RequestBody Order order, @PathVariable("customerId") int customerId) {
        
        return orderServiceImp.addOrder(order, customerId);

}
}