package com.example.demo.model;
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
@Table(name ="carriers")
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carrierId;
    private String fname;
    private String mname;
    private String lname;
    private String companyName;
    private String email;
    @OneToMany(mappedBy="carrier", cascade = CascadeType.ALL)
    private Set<Bidding> bidding;
    @OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
}
