package com.travelbooking.service;

import com.travelbooking.model.Booking;
import com.travelbooking.repository.BookingRepository;

public class BookingService {

    private final BookingRepository bookingRepository;

    // Constructor to initialize BookingRepository
    public BookingService() {
        this.bookingRepository = new BookingRepository();
    }

    public Booking createBooking(Booking booking) {
        bookingRepository.addBooking(booking);  // Using addBooking instead of save
        return booking;
    }

    // Additional methods for retrieving bookings, etc.
    public Booking findBookingById(String id) {
        return bookingRepository.findById(id);
    }

    // Any additional logic can be added here
}
