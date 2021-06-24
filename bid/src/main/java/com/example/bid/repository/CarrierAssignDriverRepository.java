package com.example.bid.repository;

import java.util.List;

import com.example.bid.model.CarrierAssignDriver;
import com.example.bid.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CarrierAssignDriverRepository extends JpaRepository<CarrierAssignDriver,Integer> {
    @Query(value = "SELECT c,d FROM CarrierAssignDriver c INNER JOIN Driver d ON c.driver = d.id  where bidding_bidding_id  =:bidId")
    public List<Driver> getAssignedDriverByBidId(int bidId);
}