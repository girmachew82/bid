package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Carrier;
import com.example.demo.repository.CarrierRepository;

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
    public ResponseEntity<List<Carrier>> getAllCarriers(Carrier carrier) {
        // TODO Auto-generated method stub
        List<Carrier> carriers = carrierRepo.findAll();
        return new ResponseEntity<>(carriers, HttpStatus.OK);
    }
    
}