package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Carrier;
import com.example.bid.repository.CarrierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarrierServiceImp  implements CarrierService{
    @Autowired
    private CarrierRepository carrierRepo;
    @Override
    public Carrier addCarrier(Carrier carrier) {
        return carrierRepo.save(carrier);
    }
    @Override
    public List<Carrier> getAllCarriers() {
        
        return carrierRepo.findAll();
    }
    
}