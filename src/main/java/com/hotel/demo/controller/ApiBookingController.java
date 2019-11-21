package com.hotel.demo.controller;

import com.hotel.demo.model.Booking;
import com.hotel.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/booking")
public class ApiBookingController {
    @Autowired
    private BookingService bookingService;

//    @GetMapping(value = "/findall", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Iterable<Booking>> findAll() {
//        try {
//            return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PostMapping(value = "/create", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
//            consumes = {MimeTypeUtils.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
//        try {
//            return new ResponseEntity<>(bookingService.save(booking), HttpStatus.OK);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping
    public ResponseEntity<List<Booking>> findAllBooking() {
        List<Booking> categoryHomes = (List<Booking>) bookingService.findAll();
        if (categoryHomes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryHomes, HttpStatus.OK);
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
    public ResponseEntity<Booking> createBoard(@RequestBody Booking booking) {
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
        bookingService.save(currentBooking.get());
        return new ResponseEntity<>(currentBooking.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        if (booking.isPresent()) {
            bookingService.remove(id);
            return new ResponseEntity<>(booking.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
