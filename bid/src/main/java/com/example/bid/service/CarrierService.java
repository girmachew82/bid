package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Carrier;

import org.springframework.http.ResponseEntity;

public interface CarrierService {
    Carrier addCarrier(Carrier carrier);
    List<Carrier> getAllCarriers();
}
