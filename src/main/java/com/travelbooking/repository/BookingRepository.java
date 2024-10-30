package com.travelbooking.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.travelbooking.config.MongoConfig;
import com.travelbooking.model.Booking;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    private final MongoCollection<Document> collection;

    public BookingRepository() {
        MongoConfig config = new MongoConfig();
        MongoDatabase database = config.getDatabase();
        this.collection = database.getCollection("bookings");
    }

    // Method to add a booking
    public void addBooking(Booking booking) {
        Document doc = new Document("userId", booking.getUserId())
            .append("travelDetails", booking.getTravelDetails());
        collection.insertOne(doc);
        booking.setId(doc.getObjectId("_id").toString());
    }

    // Method to find a booking by ID
    public Booking findById(String id) {
        Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
        if (doc != null) {
            Booking booking = new Booking();
            booking.setId(doc.getObjectId("_id").toString());
            booking.setUserId(doc.getString("userId"));
            booking.setTravelDetails(doc.getString("travelDetails"));
            return booking;
        }
        return null;
    }

    // Method to find all bookings
    public List<Booking> findAll() {
        List<Booking> bookings = new ArrayList<>();
        for (Document doc : collection.find()) {
            Booking booking = new Booking();
            booking.setId(doc.getObjectId("_id").toString());
            booking.setUserId(doc.getString("userId"));
            booking.setTravelDetails(doc.getString("travelDetails"));
            bookings.add(booking);
        }
        return bookings;
    }

    // Method to delete a booking by ID
    public void deleteById(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    // Additional methods for custom queries if needed
}
