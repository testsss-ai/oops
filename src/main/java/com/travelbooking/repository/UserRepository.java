package com.travelbooking.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.travelbooking.config.MongoConfig;
import com.travelbooking.model.User;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UserRepository {

    private final MongoCollection<Document> collection;

    public UserRepository() {
        MongoConfig config = new MongoConfig();
        MongoDatabase database = config.getDatabase();
        this.collection = database.getCollection("users");
    }

    // Method to add a new user
    public void addUser(User user) {
        Document doc = new Document("username", user.getUsername())
            .append("password", user.getPassword());
        collection.insertOne(doc);
        user.setId(doc.getObjectId("_id").toString());
    }

    // Method to find a user by username
    public User findByUsername(String username) {
        Document doc = collection.find(Filters.eq("username", username)).first();
        if (doc != null) {
            User user = new User();
            user.setId(doc.getObjectId("_id").toString());
            user.setUsername(doc.getString("username"));
            user.setPassword(doc.getString("password"));
            return user;
        }
        return null;
    }

    // Method to find a user by ID
    public User findById(String id) {
        Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();
        if (doc != null) {
            User user = new User();
            user.setId(doc.getObjectId("_id").toString());
            user.setUsername(doc.getString("username"));
            user.setPassword(doc.getString("password"));
            return user;
        }
        return null;
    }

    // Method to delete a user by ID
    public void deleteById(String id) {
        collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    // Additional methods as needed
}
