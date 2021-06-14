package com.example.bid.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Award {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private Long Id;
    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private Date awardData;
    private String driver;
	private String state;
	private String zip;
	private String country;    
}
