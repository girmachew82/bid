package com.example.bid.service;

import java.util.List;

import com.example.bid.model.Bid;
import com.example.bid.model.Order;
import com.example.bid.repository.BidRepository;
import com.example.bid.repository.CarrierRepository;
import com.example.bid.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImp implements BidService {
    @Autowired
    private BidRepository bidRepo;
    @Autowired
    private CarrierRepository carrierRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Bid addBid(Bid bid, int orderId) {
        Order order = bidRepo.getOrderIdRepo(orderId);
        bid.setOrder(order);

        return bidRepo.save(bid);
    }

    @Override
    public List<Bid> getByOrderId(int orderId) {
       // return bidRepo.getByOrderId(orderId);
       return bidRepo.getByOrderId(orderId);

    }

}