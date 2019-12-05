package com.hotel.demo.controller;

import com.hotel.demo.model.Booking;
import com.hotel.demo.model.Home;
import com.hotel.demo.service.BookingService;
import com.hotel.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/auth/booking")
public class ApiBookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<List<Booking>> findAllBooking() {
        List<Booking> bookings = (List<Booking>) bookingService.findAll();
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getIdBooking(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        if (booking.isPresent()) {
            return new ResponseEntity<>(booking.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking booking1 = booking;
        bookingService.save(booking);
        return new ResponseEntity<>(booking1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Optional<Booking> currentBooking = bookingService.findById(id);
        if (!currentBooking.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBooking.get().setId(booking.getId());
        currentBooking.get().setCheckin(booking.getCheckin());
        currentBooking.get().setCheckout(booking.getCheckout());
        currentBooking.get().setUser(booking.getUser());
        bookingService.save(currentBooking.get());
        return new ResponseEntity<>(currentBooking.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        if (booking.isPresent()) {
            bookingService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/home/{id]")
    public ResponseEntity<?> findHomeByBookingId(@PathVariable Long id) {
        List<Home> homes = (List<Home>) homeService.findAllByBooking_Id(id);
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
}
