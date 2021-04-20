package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer addCustomer(Customer customer);
   // Customer customerUpdate(int customerId);
    Customer customerUpdate(Customer customer);
    Customer getCustomerById(int customerId);
}
