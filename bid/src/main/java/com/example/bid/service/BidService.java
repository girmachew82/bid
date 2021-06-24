package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Bid;

public interface BidService {
    Bid addBid(Bid bid,  int orderId);
    List<Bid> getByOrderId(int orderId);

}