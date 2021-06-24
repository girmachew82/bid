package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;

public interface BiddingService {
    Bidding addBidding(Bidding bidding, int carrierId, int bidId);
    List<Bidding> getAllBiddings();
    //Bidding  minPrice (Bidding bidding, float minPrice);
    float  minPrice ();
    List<Bidding> getWinner();
    int updateStatus(int biddingId, String response);
    List<Bidding> showBidByStatus(String status);
    Bidding getById(int biddingId);
    List<Bidding> getByOrderId(int orderId);
   // List<Bidding> getByBidId(int biddingId2);

   // int updateDriverId(int biddingId, int driverId);

}

