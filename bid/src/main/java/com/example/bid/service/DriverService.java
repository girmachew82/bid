package com.example.demo.service;

import com.example.demo.model.Driver;

public interface DriverService {
    Driver addDriver(Driver driver, int carrierId);
    //Driver assignDriver(int driverId, int biddingId);
}
