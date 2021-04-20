package com.example.demo.service;

import com.example.demo.model.Carrier;
import com.example.demo.repository.CarrierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrierServiceImp  implements CarrierService{
    @Autowired
    private CarrierRepository carrierRepo;
    @Override
    public Carrier addCarrier(Carrier carrier) {
        return carrierRepo.save(carrier);
    }
    
}
