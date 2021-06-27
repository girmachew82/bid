package com.example.bid.repository;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer>{
    @Query(value = "SELECT c FROM Carrier c where carrier_id=:carrierId")
    // List<Order>
    List<Carrier> getByCarrierId(int carrierId);
}
