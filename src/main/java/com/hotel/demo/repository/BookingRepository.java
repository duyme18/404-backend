package com.hotel.demo.repository;

import com.hotel.demo.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("BookingRepository")
public interface BookingRepository extends CrudRepository<Booking, Long> {
}
