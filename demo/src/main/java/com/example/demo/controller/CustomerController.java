package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Customer addCustomer(@RequestBody Customer customer)
{
    return customerServiceImp.addCustomer(customer);
}
//Fetch all customer records
@GetMapping
public List<Customer> getAllCustomers()
{
    return customerServiceImp.getAllCustomers();
}

//Update Customer record
@PutMapping("/updatecustomer/{customerId}")
public ResponseEntity <String> customerUpdate(@RequestBody Customer customer)
{
    try {
        customerServiceImp.customerUpdate(customer);
        return new ResponseEntity<String>(HttpStatus.OK);
    } catch (NoSuchElementException ex) {
        //TODO: handle exception
        System.out.println(ex.getMessage());
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
}
   //Update Customer record
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
    */
    return customerServiceImp.getCustomerById(customerId);
}
//Find by id 
@GetMapping("/{customerId}")
public Customer getCustomerById(@PathVariable ("customerId") int customerId)
{
    Customer customer = customerServiceImp.getCustomerById(customerId);
    if(customer == null)
    {
      
    }
    return customerServiceImp.getCustomerById(customerId);
}

}
