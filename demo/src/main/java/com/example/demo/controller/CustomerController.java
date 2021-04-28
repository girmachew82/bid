package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

@Autowired 
private CustomerServiceImp customerServiceImp;

//Insert cusomer record
@PostMapping("/add")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
{
    return customerServiceImp.addCustomer(customer);
}
//Fetch all customer records
@GetMapping("/all")
public List<Customer> getAllCustomers()
{
    return customerServiceImp.getAllCustomers();
}

//Update Customer record
@PutMapping("/update/{customerId}")
public Customer customerUpdate(@RequestBody Customer customer, @PathVariable("customerId") int customerId)
{
  return customerServiceImp.customerUpdate(customer, customerId);
}
   //Update Customer record

/*
@GetMapping("/updatecustomer/{customerId}")
public Customer  customerUpdate(@PathVariable ("customerId")  int customerId)
{
    /*
    try {
        customerServiceImp.customerUpdate(customerId);
        return new ResponseEntity<String>(HttpStatus.OK);
    } catch (NoSuchElementException ex) {
        //TODO: handle exception
        System.out.println(ex.getMessage());
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    
    return customerServiceImp.getCustomerById(customerId);
}
*/
//Find by id 
@GetMapping("/find/{customerId}")
public Customer getCustomerById(@PathVariable ("customerId") int customerId)
{
    return customerServiceImp.getCustomerById(customerId);
}
@DeleteMapping("/delete/{customerId}")
public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int customerId) {
customerServiceImp.deleteCustomerById(customerId);
    return new ResponseEntity<>(HttpStatus.OK);
}

}
