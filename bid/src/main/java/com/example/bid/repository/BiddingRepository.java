package com.example.bid.repository;

import java.util.List;

import com.example.bid.model.Bid;
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
    @Query("select b from Bid b where id  = :bidid")
    public Bid getBidIdRepo(int bidid);
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
    @Query(value = "SELECT b FROM Bidding b  where bid_id  =:bidId")
    public List<Bidding> getByBidId(int bidId);
//SELECT d.name, e.name, e.email, e.address FROM department d INNER JOIN employee e ON d.id = e.dept_id;
    
    @Modifying
    @Query(value = "SELECT  `carriers`.`carrier_id`,`carriers`.`fname`,`carriers`.`mname`,`carriers`.`lname`,`carriers`.`address`,`carriers`.`email`,`carriers`.`company_name`,`biddings`.`bidding_id`,`biddings`.`carrie_note`,`biddings`.`delivery_datetime`,`biddings`.`etato_destination`,`biddings`.`etato_origin`,`biddings`.`expected_price`,`biddings`.`status`,`biddings`.`team_single`,`biddings`.`unit` FROM `biddings`  INNER JOIN `carriers` ON `carriers`.`carrier_id` = `biddings`.`carrier_carrier_id` WHERE `biddings`.`bid_id`=:bidId", nativeQuery=true)
    public List<Object> getCarriersByBidId(@Param("bidId") int bidId);
    /*
    @Query("from Bidding b inner join fetch b.carrier where b.bid = :id")
      List<Object> getCarriersByBidId(@Param("id") int id);
    */
    /*
    @Query(value = "SELECT c, b FROM Bidding b, Carrier c WHERE bid=:bidId")
    public List<Object> getCarriersByBidId(int bidId);
    */
    //@Query(value = "SELECT c FROM Bidding c where carrier_carrier_id  =:carrierId")
    //SELECT d.name, e.name, e.email, e.address FROM department d INNER JOIN employee e ON d.id = e.dept_id;
    // @Query(value = "SELECT b.carrier_carrier_id, c.mCNumber FROM Biddings b INNER JOIN Carriers c ON c.carrier_id = b.carrier_carrier_id")
    //public List<Bidding> getByBidId(int orderId);
    List<Object> findByStatusAndCarrier(String status, int carrier);
    List<Object> findByBidId(int bidId);
    
}
