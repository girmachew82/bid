package com.example.bid.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="carrierAssignDriver")
public class CarrierAssignDriver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignId;
    @OneToOne(fetch =  FetchType.LAZY)
    @JsonIgnore
    private Bidding bidding;
    @OneToOne(fetch = FetchType.LAZY) 
    @JsonIgnore
    private Driver driver;
    public int getAssignId() {
        return assignId;
    }
    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }
    public Bidding getBidding() {
        return bidding;
    }
    public void setBidding(Bidding bidding) {
        this.bidding = bidding;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public CarrierAssignDriver() {
    }
    public CarrierAssignDriver(int assignId, Bidding bidding, Driver driver) {
        this.assignId = assignId;
        this.bidding = bidding;
        this.driver = driver;
    }
    
}