package com.hotel.demo.service.impl;

import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.repository.CategoryRoomRepository;
import com.hotel.demo.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    @Override
    public Iterable<CategoryRoom> findAllHomeById(Long id) {
        return categoryRoomRepository.findAllHomeById(id);
    }
}
