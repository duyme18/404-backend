package com.hotel.demo.service;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.model.Home;
import com.hotel.demo.model.StatusHome;

import java.util.Optional;

public interface HomeService {
    Iterable<Home> findAll();

    Optional<Home> findById(Long id);

    void remove(Long id);

    void save(Home home);

    Iterable<Home> findAllByCategoryHomeId(Long categoryHomeId);

    Iterable<Home> findAllByCategoryRoomId(Long categoryRoomId);

    Iterable<Home> findAllByBooking_Id(Long id);

    Iterable<Home> findAllByStatusHomeId(Long statusHomeId);

    Iterable<Home> findHomeByAddressContaining(String address);

    Iterable<Home> filterAll(Integer bedroomQuantity, Integer bathroomQuantity, String address, Double priceMin, Double priceMax);

    Iterable<Home> findHomesByCategoryHomeId(Long categoryHome_id);

    Iterable<Home> findHomesByCategoryRoomId(Long categoryRoom_id);
}
