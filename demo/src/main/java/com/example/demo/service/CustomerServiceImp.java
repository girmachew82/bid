package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class CustomerServiceImp implements CustomerService{

    @Autowired
     private CustomerRepository customerRepo;

     @Override
     public Customer addCustomer(Customer customer)    
     {
         return customerRepo.save(customer);
        // return customer;
     }

     @Override
     public List<Customer> getAllCustomers()
     {
         return customerRepo.findAll();
     }
    @Override 
     public Customer customerUpdate(Customer customer) {
        //check if the customer with the passed id is exist or not

        Customer customerDB = customerRepo.findById(customer.getCustomerId()).orElseThrow();
        //If user exist then update
        //customerRepo.save(customer);       
        return customerDB;
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
       Customer customer=  customerRepo.findById(customerId).get();
       if(customer == null) {
       // throw new ResourceNotFoundException("Invalid employee id : " + customerId, null, null);
   }
     return customer;
     
     }

            
}

