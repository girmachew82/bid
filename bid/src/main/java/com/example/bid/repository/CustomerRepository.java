package com.example.bid.repository;

import java.util.Optional;

import com.example.bid.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    
}
