package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;

import org.springframework.http.ResponseEntity;

public interface CarrierService {
    Carrier addCarrier(Carrier carrier);
    List<Carrier> getAllCarriers();
    List<Carrier> getByCarrierId(int carrierId);
    List<Object> showBidByStatusNCarrierId(String status,int carrierId);
}
