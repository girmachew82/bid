package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;
import com.example.bid.repository.BiddingRepository;
import com.example.bid.repository.CarrierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarrierServiceImp  implements CarrierService{
    @Autowired
    private CarrierRepository carrierRepo;
    @Autowired
    private BiddingRepository  biddingRepo;
    @Override
    public Carrier addCarrier(Carrier carrier) {
        return carrierRepo.save(carrier);
    }
    @Override
    public List<Carrier> getAllCarriers() {
        
        return carrierRepo.findAll();
    }
    @Override
    public List<Carrier> getByCarrierId(int carrierId) {
        return carrierRepo.getByCarrierId(carrierId);
    }
    @Override
    public List<Object> showBidByStatusNCarrierId(String status,int carrierId) {
        return biddingRepo.findByStatusAndCarrier(status, carrierId);
    }
}