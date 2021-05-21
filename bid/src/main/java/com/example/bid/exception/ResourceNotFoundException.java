package com.example.bid.exception;

import java.util.Date;

public class ResourceNotFoundException {
    private String details;
    private Date timestamp;
    private String message;
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ResourceNotFoundException(String details, Date timestamp, String message) {
        this.details = details;
        this.timestamp = timestamp;
        this.message = message;
    }
    
}
