package com.hotel.demo.service;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.model.StatusHome;

import java.util.Optional;

public interface StatusHomeService {

    Iterable<StatusHome> findAll();

    Optional<StatusHome> findById(Long id);

    void remove(Long id);

    void save(StatusHome statusHome);

    Iterable<StatusHome> findAllHomeById(Long id);

}
