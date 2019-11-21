package com.hotel.demo.service;

import com.hotel.demo.model.Booking;

import java.util.Optional;

public interface BookingService {
    Iterable<Booking> findAll();

    Optional<Booking> findById(Long id);

    void remove(Long id);

    public Booking save(Booking booking);
}
