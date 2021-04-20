package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Bidding;

public interface BiddingService {
    Bidding addBidding(Bidding bidding, int carrierId, int orderId);
    List<Bidding> getAllBiddings();
    //Bidding  minPrice (Bidding bidding, float minPrice);
    float  minPrice ();
    List<Bidding> getWinner();
    int updateStatus(int biddingId, String response);
    List<Bidding> showBidByStatus(String status);
    Bidding getById(int biddingId);
    
}

