package com.example.bid.service;

import java.util.List;

import com.example.bid.model.CarrierAssignDriver;

public interface CarrierAssignDriverService {
    CarrierAssignDriver assignDriver(CarrierAssignDriver assignDriver, int biddingId, int driverId);
    List<CarrierAssignDriver> getAllAssignedDrivers();
}