package com.example.demo.controller;

import com.example.demo.model.Carrier;
import com.example.demo.service.CarrierServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrier")
public class CarrierController {
    @Autowired
    private CarrierServiceImp carrierServiceImp;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrier addCarrier(@RequestBody Carrier carrier) {
        return carrierServiceImp.addCarrier(carrier);
    }

}
