package com.example.bid.controller;

import java.util.List;

import com.example.bid.model.Bid;
import com.example.bid.service.BidServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bid")
public class BidController {
    @Autowired
    private BidServiceImp bidServiceImp;


    @PostMapping("/add/order/{orderId}")
    public Bid add(@RequestBody Bid bid, @PathVariable("orderId") int orderId) {
        return bidServiceImp.addBid(bid, orderId);
    }

    @GetMapping("/getByOrderId/{orderId}")
    public List<Bid> getByOrderId(@PathVariable("orderId") int orderId) {
        return bidServiceImp.getByOrderId(orderId);
    }
}