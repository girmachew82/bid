package com.example.bid.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Order order;
    @OneToOne(mappedBy = "bid")
    private Bidding bidding;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Bidding getBidding() {
        return bidding;
    }
    public void setBidding(Bidding bidding) {
        this.bidding = bidding;
    }
    public Bid() {
    }
    public Bid(int id, Order order, Bidding bidding) {
        this.id = id;
        this.order = order;
        this.bidding = bidding;
    }


}