package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Biddings")

public class Bidding {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int biddingId;
private String status;
private float expectedPrice;
@OneToOne
@JsonIgnore
private Carrier carrier;
@OneToOne
@JsonIgnore
private Order order;
public int getBiddingId() {
    return biddingId;
}
public void setBiddingId(int biddingId) {
    this.biddingId = biddingId;
}
public float getExpectedPrice() {
    return expectedPrice;
}
public void setExpectedPrice(float expectedPrice) {
    this.expectedPrice = expectedPrice;
}
public Carrier getCarrier() {
    return carrier;
}
public void setCarrier(Carrier carrier) {
    this.carrier = carrier;
}
public Order getOrder() {
    return order;
}
public void setOrder(Order order) {
    this.order = order;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}


    
}
