package com.example.bid.repository;

import com.example.bid.model.Carrier;
import com.example.bid.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Integer>{
   /*
    @Query("select c from Carrier c where carrier_id = :carrierId")
    public int  getCarrierIdRepo(int carrierId);
    */
}
