package com.example.bid.repository;

import java.util.List;
import java.util.Optional;

import com.example.bid.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query("select c.fname,c.mname, c.lname from Customer c")
    Object customers();
    
}
