package com.example.bid.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(nullable = false, unique = true, length = 45)
    private String fname;
    @Column(nullable = false, unique = true, length = 45)
    private String mname;
    @Column(nullable = false, unique = true, length = 45)
    private String lname;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        
        this.orders = orders;
        for(Order o:orders)
        {
            o.setCustomer(this);
        }
    }
    public Customer() {
    }

    public Customer(int customerId, String fname, String mname, String lname, String email, Set<Order> orders) {
        this.customerId = customerId;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.email = email;
        this.orders = orders;
    }

}
