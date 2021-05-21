package com.example.bid.repository;

import com.example.bid.model.Carrier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer>{
    
}
