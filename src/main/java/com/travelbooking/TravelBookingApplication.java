package com.travelbooking;

import com.travelbooking.service.UserService;
import com.travelbooking.service.BookingService;

public class TravelBookingApplication {

    public static void main(String[] args) {
        // Initialize services manually
        UserService userService = new UserService();
        BookingService bookingService = new BookingService();

        // Add your application logic here, such as user registration or booking creation
        System.out.println("Travel Booking Application Started");

        // Example usage
        // Register a new user
        // User user = new User("username", "password");
        // userService.register(user);

        // Create a new booking
        // Booking booking = new Booking(user.getId(), "Travel Details");
        // bookingService.createBooking(booking);

        System.out.println("Application Running");
    }
}
