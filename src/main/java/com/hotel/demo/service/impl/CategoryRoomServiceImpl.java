package com.hotel.demo.service.impl;

import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.repository.CategoryRoomRepository;
import com.hotel.demo.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoryRoomServiceImpl implements CategoryRoomService {
    @Autowired
    private CategoryRoomRepository categoryRoomRepository;

    @Override
    public Iterable<CategoryRoom> findAll() {
        return categoryRoomRepository.findAll();
    }

    @Override
    public Optional<CategoryRoom> findById(Long id) {
        return categoryRoomRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        categoryRoomRepository.deleteById(id);
    }

    @Override
    public void save(CategoryRoom categoryRoom) {
        categoryRoomRepository.save(categoryRoom);
    }
}
