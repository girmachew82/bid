package com.example.bid.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverId")
    private int driverId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="carrier_id",nullable = false)
    private Carrier carrier;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CarrierAssignDriver carrierAssignDriver;
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Carrier getCarrier() {
        return carrier;
    }
    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public CarrierAssignDriver getCarrierAssignDriver() {
        return carrierAssignDriver;
    }
    public void setCarrierAssignDriver(CarrierAssignDriver carrierAssignDriver) {
        this.carrierAssignDriver = carrierAssignDriver;
    }
    public Driver() {
    }
    public Driver(int driverId, String firstName, String middleName, String lastName, String phoneNumber, String status,
            Carrier carrier, CarrierAssignDriver carrierAssignDriver) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.carrier = carrier;
        this.carrierAssignDriver = carrierAssignDriver;
    }
   
}
