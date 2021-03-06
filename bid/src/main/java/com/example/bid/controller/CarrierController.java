package com.example.bid.controller;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;
import com.example.bid.service.CarrierServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrier addCarrier(@RequestBody Carrier carrier) {
        return carrierServiceImp.addCarrier(carrier);
    }
    @GetMapping("/all")
    public List<Carrier> getAllCarriers() {
        return carrierServiceImp.getAllCarriers();
    }
    @GetMapping("/getById/{carrierId}")
    public List<Carrier> getByCarrierId(@PathVariable("carrierId")int carrierId) {
        return carrierServiceImp.getByCarrierId(carrierId);
    }
    @GetMapping("/showByStatusNCarrierId/status/{status}/carrierId/{carrierId}")
    public List<Object>  showByStatusNCarrierId(@PathVariable("status") String status,@PathVariable("carrierId") int carrierId) {
        return carrierServiceImp.showBidByStatusNCarrierId(status,carrierId);
      }
}
