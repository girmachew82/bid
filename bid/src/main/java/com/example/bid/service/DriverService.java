package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Driver;

public interface DriverService {
    Driver addDriver(Driver driver, int carrierId);
    //Driver assignDriver(int driverId, int biddingId);
    List<Driver> getAll();
}
