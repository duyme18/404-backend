package com.hotel.demo.service;

import com.hotel.demo.model.Booking;

import java.util.Optional;

public interface BookingService {
    Iterable<Booking> findAll();

    Optional<Booking> findById(Long id);

    void remove(Long id);

    Booking save(Booking booking);

    Iterable<Booking> findBookingsByUserId(Long user_id);

    Iterable<Booking> findBookingsById(Long id);
}
