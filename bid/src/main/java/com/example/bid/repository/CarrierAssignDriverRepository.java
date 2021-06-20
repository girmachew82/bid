package com.example.bid.repository;

import com.example.bid.model.CarrierAssignDriver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarrierAssignDriverRepository extends JpaRepository<CarrierAssignDriver,Integer> {
    
}