package com.example.bid.repository;

import java.util.List;
import java.util.Optional;

import com.example.bid.model.Customer;
import com.example.bid.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

  // List<Order> findByCustomerId(int customerId);
  @Query(value = "SELECT o FROM Order o where customer_id=:customerId")
  // List<Order>
  List<Order> getByCustomerId(int customerId);

  List<Order> getByOrderType(String type);
}
