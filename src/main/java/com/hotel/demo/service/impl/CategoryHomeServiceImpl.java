package com.hotel.demo.service.impl;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.repository.CategoryHomeRepository;
import com.hotel.demo.service.CategoryHomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoryHomeServiceImpl implements CategoryHomeService {
    @Autowired
    private CategoryHomeRepository categoryHomeRepository;

    @Override
    public Iterable<CategoryHome> findAll() {
        return categoryHomeRepository.findAll();
    }

    @Override
    public Optional<CategoryHome> findById(Long id) {
        return categoryHomeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        categoryHomeRepository.deleteById(id);
    }

    @Override
    public void save(CategoryHome categoryHome) {
        categoryHomeRepository.save(categoryHome);
    }
}