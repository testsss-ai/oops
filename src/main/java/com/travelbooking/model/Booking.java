package com.travelbooking.model;

public class Booking {
    private String id;        // This will store MongoDB's "_id" field manually
    private String userId;
    private String travelDetails;

    // Constructors
    public Booking() {}

    public Booking(String userId, String travelDetails) {
        this.userId = userId;
        this.travelDetails = travelDetails;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(String travelDetails) {
        this.travelDetails = travelDetails;
    }
}
