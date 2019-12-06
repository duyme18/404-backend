package com.hotel.demo.service;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.model.CategoryRoom;

import java.util.Optional;

public interface CategoryRoomService {
    Iterable<CategoryRoom> findAll();

    Optional<CategoryRoom> findById(Long id);

    void remove(Long id);

    void save(CategoryRoom categoryRoom);

    Iterable<CategoryRoom> findAllHomeById(Long id);

    Iterable<CategoryRoom> findAllByNameContaining(String categoryRoom_name);

}
