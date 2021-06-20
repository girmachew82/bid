package com.example.bid.controller;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.repository.BiddingRepository;
import com.example.bid.service.BiddingServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bidding")
public class BiddingController {
    @Autowired
    private BiddingServiceImp biddingServiceImp;
    
    @PostMapping("/add/carrier/{carrierId}/order/{orderId}")
    public Bidding addBidding(@RequestBody Bidding bidding, @PathVariable("carrierId") int carrierId, @PathVariable("orderId") int orderId) {
        return biddingServiceImp.addBidding(bidding, carrierId, orderId);
    }
    @GetMapping("/all")
    public List<Bidding> getAllBiddings() {
        return biddingServiceImp.getAllBiddings();
     }
     /*
     @GetMapping("/minPrice")
     public Bidding  minPrice(@RequestBody Bidding bzidding, float miniprice) {
         return biddingServiceImp.minPrice(bidding, miniprice);
     }
     */
    @GetMapping("/minPrice")
    public float  minPrice() {
        return biddingServiceImp.minPrice();
    }
    @GetMapping("/winner")
    public List<Bidding>  getWinner() {
        return biddingServiceImp.getWinner();
    }
    @PutMapping("/updateStatus/{biddingId}/{status}/status")
    public int updateStatus(@PathVariable("biddingId") int biddingId, @PathVariable("status") String status) {
        return biddingServiceImp.updateStatus(biddingId,status);
        //return biddingId+status.length();
   }
   @GetMapping("/showByStatus/{status}")
   public List<Bidding>  showByStatus(@PathVariable("status") String status) {
       return biddingServiceImp.showBidByStatus(status);
   }
   @GetMapping("/getById/{biddingId}")
   public Bidding  getById(@PathVariable("biddingId") int biddingId) {
       return biddingServiceImp.getById(biddingId);
   }
   @GetMapping("/getByOrderId/{orderId}")
   public List<Bidding>  getByOrderId(@PathVariable("orderId") int orderId) {
       return biddingServiceImp.getByOrderId(orderId);
   }

   @PutMapping("/assignDriver/{biddingId}/{driverId}/driver")
   public int assignDriver(@PathVariable("biddingId") int biddingId, @PathVariable("driverId") int driverId) {
       return biddingServiceImp.updateDriverId(biddingId,driverId);
       //return biddingId+status.length();
  }
}
  
