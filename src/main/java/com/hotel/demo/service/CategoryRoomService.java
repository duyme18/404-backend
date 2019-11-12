package com.hotel.demo.service;

import com.hotel.demo.model.CategoryRoom;

import java.util.Optional;

public interface CategoryRoomService {
    Iterable<CategoryRoom> findAll();

    Optional<CategoryRoom> findById(Long id);

    void remove(Long id);

    void save(CategoryRoom categoryRoom);
}
