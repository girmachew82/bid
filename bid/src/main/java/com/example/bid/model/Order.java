package com.example.bid.model;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
private int quantity;
private String itemName;
private String fromLocation;
private String toLocation;
@JsonFormat(pattern="MM-dd-yyyy")
private Date orderDate;
@JsonFormat(pattern="MM-dd-yyyy")
private Date expectedDate;
private int    orderStatus;
private String orderDescription;
@ManyToOne(fetch = FetchType.LAZY, optional = false) 
@JsonIgnore
@JoinColumn(name="customer_id",nullable = false)
private Customer customer;
@OneToOne(fetch =  FetchType.LAZY)
private Bidding bidding;
public int getOrderId() {
        return orderId;
    }
public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
public int getQuantity() {
        return quantity;
    }
public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
@Column(name="itemName")
public String getItemName() {
        return itemName;
    }
public void setItemName(String itemName) {
        this.itemName = itemName;
    }
@Column(name="fromLocation")
public String getFromLocation() {
        return fromLocation;
    }
public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }
@Column(name="getLocation")
public String getToLocation() {
        return toLocation;
    }
public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
public Customer getCustomer() {
        return customer;
    }
public void setCustomer(Customer customer) {
        this.customer = customer;
    }
public Date getOrderDate() {
        return orderDate;
    }
public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
public Date getExpectedDate() {
        return expectedDate;
    }
public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }
public int getOrderStatus() {
        return orderStatus;
    }
public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
public String getOrderDescription() {
        return orderDescription;
    }
public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
public Bidding getBidding() {
        return bidding;
    }
public void setBidding(Bidding bidding) {
        this.bidding = bidding;
    }
    
public Order() {
}
public Order(int orderId, int quantity, String itemName, String fromLocation, String toLocation, Date orderDate,
        Date expectedDate, int orderStatus, String orderDescription, Customer customer, Bidding bidding) {
    this.orderId = orderId;
    this.quantity = quantity;
    this.itemName = itemName;
    this.fromLocation = fromLocation;
    this.toLocation = toLocation;
    this.orderDate = orderDate;
    this.expectedDate = expectedDate;
    this.orderStatus = orderStatus;
    this.orderDescription = orderDescription;
    this.customer = customer;
    this.bidding = bidding;
}
    
}
