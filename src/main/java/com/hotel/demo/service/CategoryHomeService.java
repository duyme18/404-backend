package com.hotel.demo.service;

import com.hotel.demo.model.CategoryHome;

import java.util.Optional;

public interface CategoryHomeService {
    Iterable<CategoryHome> findAll();

    Optional<CategoryHome> findById(Long id);

    void remove(Long id);

    void save(CategoryHome categoryHome);
}
