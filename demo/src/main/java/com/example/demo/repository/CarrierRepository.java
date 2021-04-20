package com.example.demo.repository;

import com.example.demo.model.Carrier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer>{
    
}
