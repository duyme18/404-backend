package com.hotel.demo.service.impl;

import com.hotel.demo.model.Booking;
import com.hotel.demo.repository.BookingRepository;
import com.hotel.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("BookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Iterable<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Iterable<Booking> findBookingsByUserId(Long user_id) {
        return bookingRepository.findBookingsByUser_Id(user_id);
    }

    @Override
    public Iterable<Booking> findBookingsById(Long id) {
        return bookingRepository.findBookingsById(id);
    }

}
