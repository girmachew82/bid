package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderRepository orderRepo;
    @Autowired 
    private CustomerRepository customerRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    
    @Override
    public Order addOrder (Order order, int customerId) {

       return customerRepo.findById(customerId).map(customer ->{
                  order.setCustomer(customer);
       return orderRepo.save(order);
       //return order;
       }).orElseThrow();
       
       
    } 
}
