package com.example.bid.service;

import com.example.bid.model.Carrier;
import com.example.bid.model.Driver;
import com.example.bid.repository.BiddingRepository;
import com.example.bid.repository.CarrierRepository;
import com.example.bid.repository.DriverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImp implements DriverService{
    @Autowired
    DriverRepository driverRepo;
    @Autowired
    CarrierRepository carrierRepo;
    @Autowired
    BiddingRepository biddingRepo;
 /*
    @Override 
    public Driver addDriver(Driver driver, int carrierId) {
        Carrier carrier = driverRepo.getCarrierIdRepo(carrierId);
        driver.setCarrier(carrier);
        return driverRepo.save(driver);

    }
    */
    @Override
    public Driver addDriver (Driver driver, int carrierId) {

       return carrierRepo.findById(carrierId).map(carrier ->{
                  driver.setCarrier(carrier);
       return driverRepo.save(driver);
       //return order;
       }).orElseThrow();
       
    }
    /*
    @Override
    public Driver assignDriver (int driverId, int biddingId) {

       return driverRepo.findById(driverId.map(driver ->{
                  
       return driverRepo.save(driver);
       //return order;
       }).orElseThrow();
       
    }
    */
}
