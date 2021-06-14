package com.example.bid.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;
import com.example.bid.model.Order;
import com.example.bid.repository.BiddingRepository;
import com.example.bid.repository.CarrierRepository;
import com.example.bid.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BiddingServiceImp implements BiddingService {
 
    @Autowired
    private BiddingRepository biddingRepo;
    @Autowired 
    private CarrierRepository carrierRepo;
    @Autowired
    private OrderRepository orderRepo;
    
    public Bidding addBidding(Bidding bidding, int carrierid, int orderid) {

        Order order = biddingRepo.getOrderIdRepo(orderid);
        bidding.setOrder(order);
        Carrier carrier = biddingRepo.getCarrierIdRepo(carrierid);
        bidding.setCarrier(carrier);
        
        return biddingRepo.save(bidding);
       }
    @Override
    public List<Bidding> getAllBiddings()
    {
        return biddingRepo.findAll();
    }
/*
    @Override
	public Bidding minPrice(Bidding bidding, float minprice) {
       // Bidding bid = biddingRepo.getMinPrice();
    
		return biddingRepo.getMinPrice();
	}
    */
    @Override
	public float minPrice() {
       // Bidding bid = biddingRepo.getMinPrice();
    
		return biddingRepo.getMinPrice();
	}
    @Override
    public List<Bidding> getWinner() {
        return biddingRepo.getWinner();
    }
    @Override
    public int updateStatus(int biddingId, String status) {
        return biddingRepo.updatestatusRepo(biddingId, status);
        //return biddingId+status.length();
    }
    
    @Override
    public List<Bidding> showBidByStatus(String status) {
        return biddingRepo.showBidByStatusRepo(status);
        //return biddingId+status.length();
    }
    @Override
    public Bidding getById(int biddingId) {
        return biddingRepo.findById(biddingId).get();
        //return biddingId+status.length();
    }
    @Override
    public List<Bidding> getByOrderId(int orderId) {
        return biddingRepo.getByOrderId(orderId);
    }
}

