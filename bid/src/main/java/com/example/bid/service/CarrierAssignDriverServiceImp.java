package com.example.bid.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.bid.model.Bidding;
import com.example.bid.model.CarrierAssignDriver;
import com.example.bid.model.Driver;
import com.example.bid.repository.BiddingRepository;
import com.example.bid.repository.CarrierAssignDriverRepository;
import com.example.bid.repository.DriverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class CarrierAssignDriverServiceImp implements CarrierAssignDriverService{
    @Autowired
    private CarrierAssignDriverRepository carrierAssignDriverRepo;
    @Autowired
    private BiddingRepository biddingRepo;
    @Autowired
    private DriverRepository driverRepo; 
    
    @Override
    public CarrierAssignDriver assignDriver(CarrierAssignDriver assignDriver, int biddingId, int driverId) {
        
        Bidding bidding = biddingRepo.getById(biddingId);
        assignDriver.setBidding(bidding);
        Driver driver = driverRepo.getById(driverId);
        assignDriver.setDriver(driver);
        return carrierAssignDriverRepo.save(assignDriver);
    }
    @Override
    public List<CarrierAssignDriver> getAllAssignedDrivers() {
        
        return carrierAssignDriverRepo.findAll();
    }
    
    @Override
    public List<Driver> getAssignedDriver(int bidId) {
        return carrierAssignDriverRepo.getAssignedDriverByBidId(bidId);
    }
}