package com.example.bid.service;

import java.net.URI;
import java.util.List;

import com.example.bid.exception.ResourceNotFoundException;
import com.example.bid.model.Customer;
import com.example.bid.repository.CustomerRepository;

import org.dom4j.IllegalAddException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service

public class CustomerServiceImp implements CustomerService{

    @Autowired
     private CustomerRepository customerRepo;

     @Override
     public ResponseEntity<Customer> addCustomer(Customer customer)    
     {
         Customer savedCustomer =this.customerRepo.save(customer);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedCustomer.getCustomerId()).toUri();
         return ResponseEntity.created(location).build();
        // return customer;
     }

     @Override
     public List<Customer> getAllCustomers()
     {
         return customerRepo.findAll();
     }
     
     @Override
     public List<Object> customers()
     {
         return customerRepo.customers();
     }
    @Override 
     public Customer customerUpdate(Customer customer, int customerId) {
    boolean exist=  customerRepo.existsById(customerId);
       if(!exist) {
        throw new IllegalAddException("Unavailable employee id : " + customerId);
   }
    customer = customerRepo.save(customer);
     return customer;
            }

     /*       
    @Override 
    public Customer customerUpdate(int customer) {
               //check if the customer with the passed id is exist or not
       
               Customer customerDB = customerRepo.findById(customer).orElseThrow();
               //If user exist then update
               //customerRepo.save(customer);       
               return customerDB;
                   }  
                   */  
    @Override
    public Customer getCustomerById(int customerId)           
     {
       boolean exist=  customerRepo.existsById(customerId);
       if(!exist) {
        throw new IllegalAddException("Unavailable customer id : " + customerId);
   }
   Customer customer = customerRepo.findById(customerId).get();
     return customer;
     
     }

    @Override
    public void deleteCustomerById(int customerId) {
        // TODO Auto-generated method stub
        boolean exist = customerRepo.existsById(customerId);
        if(!exist)
        {
            throw new IllegalAddException("Unavailable customer id"+ customerId);
        }
        customerRepo.deleteById(customerId);
    }

            
}

