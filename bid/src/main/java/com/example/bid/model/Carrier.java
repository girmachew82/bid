package com.example.bid.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carriers")
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carrierId;
    private String fname;
    private String mname;
    private String lname;
    private String address;
    private String mCNumber;
    private String dOTNumber;
    private String companyName;
    private String email;
    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bidding> bidding;
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Driver> driver;
    public int getCarrierId() {
        return carrierId;
    }
    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getmCNumber() {
        return mCNumber;
    }
    public void setmCNumber(String mCNumber) {
        this.mCNumber = mCNumber;
    }
    public String getdOTNumber() {
        return dOTNumber;
    }
    public void setdOTNumber(String dOTNumber) {
        this.dOTNumber = dOTNumber;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Bidding> getBidding() {
        return bidding;
    }
    public void setBidding(Set<Bidding> bidding) {
        this.bidding = bidding;
    }
    public Set<Driver> getDriver() {
        return driver;
    }
    public void setDriver(Set<Driver> driver) {
        this.driver = driver;
    }


    public Carrier() {
    }
    public Carrier(int carrierId, String fname, String mname, String lname, String address, String mCNumber,
            String dOTNumber, String companyName, String email, Set<Bidding> bidding, Set<Driver> driver) {
        this.carrierId = carrierId;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.address = address;
        this.mCNumber = mCNumber;
        this.dOTNumber = dOTNumber;
        this.companyName = companyName;
        this.email = email;
        this.bidding = bidding;
        this.driver = driver;
    }

  
}
