package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Customer;
import com.example.bid.model.Order;
import com.example.bid.repository.CustomerRepository;
import com.example.bid.repository.OrderRepository;

import org.dom4j.IllegalAddException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order addOrder(Order order, int customerId) {

        return customerRepo.findById(customerId).map(customer -> {
            order.setCustomer(customer);
            return orderRepo.save(order);
            // return order;
        }).orElseThrow();

    }

    @Override
    public List<Order> getOrderByType(String type) {
        return orderRepo.getByOrderType(type);
    }

    @Override
    public List<Order> getByCustomerId(int customerId) {
        return orderRepo.getByCustomerId(customerId);
        
    }
    @Override
    public Order getById(int orderId) {
        boolean exist=  orderRepo.existsById(orderId);
        if(!exist) {
         throw new IllegalAddException("Unavailable Order id : " + orderId);
    }
    Order order = orderRepo.findById(orderId).get();
      return order;
    }
}

