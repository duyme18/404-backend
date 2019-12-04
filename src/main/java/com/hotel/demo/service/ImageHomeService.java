package com.hotel.demo.service;

import com.hotel.demo.model.ImageHome;

import java.awt.*;
import java.util.Optional;

public interface ImageHomeService {
    Iterable<ImageHome> findAll();

    Optional<ImageHome> findById(Long id);

    void save(ImageHome imageHome);

    void remove(Long id);

    Iterable<ImageHome> findAllByHome_Id(Long home_id);
}
