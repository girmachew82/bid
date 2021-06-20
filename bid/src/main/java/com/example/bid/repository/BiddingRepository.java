package com.example.bid.repository;

import java.util.List;

import com.example.bid.model.Bidding;
import com.example.bid.model.Carrier;
import com.example.bid.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Integer> {
    @Query("select o from Order o where order_id  = :orderid")
    public Order getOrderIdRepo(int orderid);

    @Query("select c from Carrier c where carrier_id = :carrierid")
    public Carrier getCarrierIdRepo(int carrierid);
    /*
     * @Query(value= "SELECT min(expectedPrice) FROM Bidding") public Bidding
     * getMinPrice();
     */

    @Query(value = "SELECT min(expectedPrice),biddingId FROM Bidding")
    public float getMinPrice();

    @Query(value = "SELECT  min(expectedPrice) FROM Bidding w ")
    public List<Bidding> getWinner();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Bidding b SET b.status = :status WHERE b.biddingId = :biddingId")
    public int updatestatusRepo(@Param("biddingId") int biddingId, @Param("status") String status);
/*
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Bidding a SET a.driverId  = :driverId  WHERE a.biddingId  = :biddingId ")
    public int updateDriverRepo(@Param("biddingId") int biddingId, @Param("driverId") int driverId);
*/
    @Query(value = "SELECT s FROM Bidding s where status =:status")
    public List<Bidding> showBidByStatusRepo(String status);

    @Query(value = "SELECT b FROM Bidding b where order_order_id  =:orderId")
    public List<Bidding> getByOrderId(int orderId);
}
