package com.example.bid.controller;

import java.util.List;

import com.example.bid.model.CarrierAssignDriver;
import com.example.bid.service.CarrierAssignDriverServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrierAssignDriver")
public class CarrierAssignDriverController {
    @Autowired
    private CarrierAssignDriverServiceImp carrierAssignDriverServiceImp;
    
    @PostMapping("/add/bidding/{biddingId}/driver/{driverId}")
    public CarrierAssignDriver assignDriver(@RequestBody CarrierAssignDriver carrierAssignDriver, @PathVariable("biddingId") int biddingId, @PathVariable("driverId") int driverId) {
        return carrierAssignDriverServiceImp.assignDriver(carrierAssignDriver, biddingId, driverId);
    }
    @GetMapping("/all")
    public List<CarrierAssignDriver> allAssignedDrivers() {
        return carrierAssignDriverServiceImp.getAllAssignedDrivers();
    }
}