package com.travelbooking.service;

import com.travelbooking.model.User;
import com.travelbooking.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    // Constructor to initialize UserRepository
    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User register(User user) {
        userRepository.addUser(user);  // Use addUser instead of save
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Additional methods for authentication, etc.
    public User findById(String id) {
        return userRepository.findById(id);
    }
    
    // Any additional logic can be added here
}
