package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Carrier;

import org.springframework.http.ResponseEntity;

public interface CarrierService {
    Carrier addCarrier(Carrier carrier);
    ResponseEntity<List<Carrier>> getAllCarriers(Carrier carrier);
}
