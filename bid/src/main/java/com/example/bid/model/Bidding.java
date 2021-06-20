package com.example.bid.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Biddings")

public class Bidding {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int biddingId;
private String status;
private float expectedPrice;
@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
private Date eTAtoOrigin;
@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
private Date eTAtoDestination;
private String teamSingle;
private String unit;
private String carrieNote;
@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
private Date deliveryDatetime;
@OneToOne(fetch = FetchType.LAZY)
@JsonIgnore
private Carrier carrier;
@OneToOne(fetch =  FetchType.LAZY)
@JsonIgnore
private Order order;
@OneToOne(fetch = FetchType.LAZY)
@JsonIgnore

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

public Date getDeliveryDatetime() {
    return deliveryDatetime;
}
public void setDeliveryDatetime(Date deliveryDatetime) {
    this.deliveryDatetime = deliveryDatetime;
}

public Date geteTAtoOrigin() {
    return eTAtoOrigin;
}
public void seteTAtoOrigin(Date eTAtoOrigin) {
    this.eTAtoOrigin = eTAtoOrigin;
}
public Date geteTAtoDestination() {
    return eTAtoDestination;
}
public void seteTAtoDestination(Date eTAtoDestination) {
    this.eTAtoDestination = eTAtoDestination;
}
public String getTeamSingle() {
    return teamSingle;
}
public void setTeamSingle(String teamSingle) {
    this.teamSingle = teamSingle;
}
public String getUnit() {
    return unit;
}
public void setUnit(String unit) {
    this.unit = unit;
}
public String getCarrieNote() {
    return carrieNote;
}
public void setCarrieNote(String carrieNote) {
    this.carrieNote = carrieNote;
}


public Bidding() {
}
public Bidding(int biddingId, String status, float expectedPrice, Date eTAtoOrigin, Date eTAtoDestination,
        String teamSingle, String unit, String carrieNote, Date deliveryDatetime, Carrier carrier, Order order) {
    this.biddingId = biddingId;
    this.status = status;
    this.expectedPrice = expectedPrice;
    this.eTAtoOrigin = eTAtoOrigin;
    this.eTAtoDestination = eTAtoDestination;
    this.teamSingle = teamSingle;
    this.unit = unit;
    this.carrieNote = carrieNote;
    this.deliveryDatetime = deliveryDatetime;
    this.carrier = carrier;
    this.order = order;
}


    
}
