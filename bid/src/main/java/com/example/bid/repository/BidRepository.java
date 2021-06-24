package com.example.bid.repository;

import java.util.List;

import com.example.bid.model.Bid;
import com.example.bid.model.Bidding;
import com.example.bid.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {
   
    @Query("select b from Bid b where id  = :bidid")
    public Bid getBidIdRepo(int bidid);
    @Query("select o from Order o where order_id  = :orderid")
    public Order getOrderIdRepo(int orderid);
    @Query(value = "SELECT b FROM Bid b where order_order_id  =:orderId")
    public List<Bid> getByOrderId(int orderId);
}