package com.example.bid.model;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name ="orders")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int orderId;
private String oLName;
private String oLpuAddress;
private String oLzipCode;
@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
private Date oSrtData;
private String dLName;
private String dLpdAddress;
private String dLzipCode;
@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
private Date dDnptDate;
private Long noofUnitShipping;
private String typeofUnit;
private Float weight;
private Float dimension;
private int   biddingStatus;
private String hazardousness;
private String cargonotes;
private String orderType;
private String deliveryStatus;

@ManyToOne(fetch = FetchType.LAZY, optional = false) 
@JsonIgnore
@JoinColumn(name="customer_id",nullable = false)
private Customer customer;
@OneToMany(mappedBy = "order", fetch =  FetchType.LAZY)
private Set<Bidding> bidding;
@OneToOne(mappedBy = "order")
private Bid bid;
public int getOrderId() {
    return orderId;
}
public void setOrderId(int orderId) {
    this.orderId = orderId;
}
public String getoLName() {
    return oLName;
}
public void setoLName(String oLName) {
    this.oLName = oLName;
}
public String getoLpuAddress() {
    return oLpuAddress;
}
public void setoLpuAddress(String oLpuAddress) {
    this.oLpuAddress = oLpuAddress;
}
public String getoLzipCode() {
    return oLzipCode;
}
public void setoLzipCode(String oLzipCode) {
    this.oLzipCode = oLzipCode;
}

public String getdLName() {
    return dLName;
}
public void setdLName(String dLName) {
    this.dLName = dLName;
}
public String getdLpdAddress() {
    return dLpdAddress;
}
public void setdLpdAddress(String dLpdAddress) {
    this.dLpdAddress = dLpdAddress;
}
public String getdLzipCode() {
    return dLzipCode;
}
public void setdLzipCode(String dLzipCode) {
    this.dLzipCode = dLzipCode;
}

public Long getNoofUnitShipping() {
    return noofUnitShipping;
}
public void setNoofUnitShipping(Long noofUnitShipping) {
    this.noofUnitShipping = noofUnitShipping;
}
public String getTypeofUnit() {
    return typeofUnit;
}
public void setTypeofUnit(String typeofUnit) {
    this.typeofUnit = typeofUnit;
}
public Float getWeight() {
    return weight;
}
public void setWeight(Float weight) {
    this.weight = weight;
}
public Float getDimension() {
    return dimension;
}
public void setDimension(Float dimension) {
    this.dimension = dimension;
}

public String getHazardousness() {
    return hazardousness;
}
public void setHazardousness(String hazardousness) {
    this.hazardousness = hazardousness;
}
public String getCargonotes() {
    return cargonotes;
}
public void setCargonotes(String cargonotes) {
    this.cargonotes = cargonotes;
}
public Customer getCustomer() {
    return customer;
}
public void setCustomer(Customer customer) {
    this.customer = customer;
}

public String getOrderType() {
    return orderType;
}
public void setOrderType(String orderType) {
    this.orderType = orderType;
}

public int getBiddingStatus() {
    return biddingStatus;
}
public void setBiddingStatus(int biddingStatus) {
    this.biddingStatus = biddingStatus;
}
public String getDeliveryStatus() {
    return deliveryStatus;
}
public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
}
public Date getoSrtData() {
    return oSrtData;
}
public void setoSrtData(Date oSrtData) {
    this.oSrtData = oSrtData;
}
public Date getdDnptDate() {
    return dDnptDate;
}
public void setdDnptDate(Date dDnptDate) {
    this.dDnptDate = dDnptDate;
}

public Set<Bidding> getBidding() {
    return bidding;
}
public void setBidding(Set<Bidding> bidding) {
    this.bidding = bidding;
}

public Bid getBid() {
    return bid;
}
public void setBid(Bid bid) {
    this.bid = bid;
}
public Order() {
}
public Order(int orderId, String oLName, String oLpuAddress, String oLzipCode, Date oSrtData, String dLName,
        String dLpdAddress, String dLzipCode, Date dDnptDate, Long noofUnitShipping, String typeofUnit, Float weight,
        Float dimension, int biddingStatus, String hazardousness, String cargonotes, String orderType,
        String deliveryStatus, Customer customer, Set<Bidding> bidding, Bid bid) {
    this.orderId = orderId;
    this.oLName = oLName;
    this.oLpuAddress = oLpuAddress;
    this.oLzipCode = oLzipCode;
    this.oSrtData = oSrtData;
    this.dLName = dLName;
    this.dLpdAddress = dLpdAddress;
    this.dLzipCode = dLzipCode;
    this.dDnptDate = dDnptDate;
    this.noofUnitShipping = noofUnitShipping;
    this.typeofUnit = typeofUnit;
    this.weight = weight;
    this.dimension = dimension;
    this.biddingStatus = biddingStatus;
    this.hazardousness = hazardousness;
    this.cargonotes = cargonotes;
    this.orderType = orderType;
    this.deliveryStatus = deliveryStatus;
    this.customer = customer;
    this.bidding = bidding;
    this.bid = bid;
}

}