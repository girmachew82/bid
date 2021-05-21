package com.example.bid.repository;

import java.util.List;
import java.util.Optional;

import com.example.bid.model.Customer;
import com.example.bid.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
    
  Customer findById(int customerId);
  //Optional<Customer> findByOrderIdANDCustomerId(int orderId, int customerId);
    
}
