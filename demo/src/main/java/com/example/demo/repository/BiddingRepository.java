package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Bidding;
import com.example.demo.model.Carrier;
import com.example.demo.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BiddingRepository extends JpaRepository<Bidding,Integer>{
    @Query("select o from Order o where order_id  = :orderid")
    public Order  getOrderIdRepo(int orderid);
    @Query("select c from Carrier c where carrier_id = :carrierid")
    public Carrier  getCarrierIdRepo(int carrierid);
    /*
    @Query(value= "SELECT min(expectedPrice) FROM Bidding")
     public  Bidding getMinPrice();
     */
    
    @Query(value= "SELECT min(expectedPrice),biddingId FROM Bidding")
     public  float getMinPrice();
     
    @Query(value= "SELECT w FROM Bidding w")
    public List<Bidding> getWinner();
     
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Bidding b SET b.status = :status WHERE b.biddingId = :biddingId")
    public int updatestatusRepo(@Param("biddingId") int biddingId, @Param("status") String status);
    
    
    @Query(value= "SELECT s FROM Bidding s where status =:status")
    public List<Bidding> showBidByStatusRepo(String status);
}
