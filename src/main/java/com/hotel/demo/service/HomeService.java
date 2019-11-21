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

    Iterable<Home> findAllByCategoryHome(CategoryHome categoryHome);

    Iterable<Home> findAllByCategoryRoom(CategoryRoom categoryRoom);

    Iterable<Home> findAllByStatusHome(StatusHome statusHome);

    Iterable<Home> findHomeByAddressContaining(String address);
}
