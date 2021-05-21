package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Customer;

import org.springframework.http.ResponseEntity;

public interface CustomerService {
    List<Customer> getAllCustomers();
    ResponseEntity<Customer> addCustomer(Customer customer);
   // Customer customerUpdate(int customerId);
    Customer customerUpdate(Customer customer, int customerId);
    Customer getCustomerById(int customerId);
    void deleteCustomerById(int customerId);

}
