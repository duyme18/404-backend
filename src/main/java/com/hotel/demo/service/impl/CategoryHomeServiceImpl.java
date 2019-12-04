package com.hotel.demo.service.impl;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.repository.CategoryHomeRepository;
import com.hotel.demo.service.CategoryHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    @Override
    public Iterable<CategoryHome> findAllHomeById(Long id) {
        return categoryHomeRepository.findAllHomeById(id);
    }
}
