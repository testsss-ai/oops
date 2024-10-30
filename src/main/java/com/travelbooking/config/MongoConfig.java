package com.travelbooking.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

    // Replace with your MongoDB connection string if using a different host/port
    private static final String MONGO_DB_URL = "mongodb://localhost:27017/";
    
    // Replace with your actual database name
    private static final String DATABASE_NAME = "TRAVEI";

    // Method to create a MongoClient
    public MongoClient mongoClient() {
        return MongoClients.create(MONGO_DB_URL);
    }

    // Method to get the MongoDatabase instance
    public MongoDatabase getDatabase() {
        return mongoClient().getDatabase(DATABASE_NAME);
    }
}
