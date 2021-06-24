package com.example.bid.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Order order;
    @OneToMany(mappedBy = "bid",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Bidding> bidding;
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

    public List<Bidding> getBidding() {
        return bidding;
    }
    public void setBidding(List<Bidding> bidding) {
        this.bidding = bidding;
    }
    public Bid() {
    }
    public Bid(int id, Order order, List<Bidding> bidding) {
        this.id = id;
        this.order = order;
        this.bidding = bidding;
    }



}