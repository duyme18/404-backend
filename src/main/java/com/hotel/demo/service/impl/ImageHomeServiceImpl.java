package com.hotel.demo.service.impl;

import com.hotel.demo.model.ImageHome;
import com.hotel.demo.repository.ImageHomeRepository;
import com.hotel.demo.service.ImageHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageHomeServiceImpl implements ImageHomeService {

    @Autowired
    public ImageHomeRepository imageHomeRepository;

    @Override
    public Iterable<ImageHome> findAll() {
        return imageHomeRepository.findAll();
    }

    @Override
    public Optional<ImageHome> findById(Long id) {
        return imageHomeRepository.findById(id);
    }

    @Override
    public void save(ImageHome imageHome) {
        imageHomeRepository.save(imageHome);
    }

    @Override
    public void remove(Long id) {
        imageHomeRepository.deleteById(id);
    }

    @Override
    public Iterable<ImageHome> findAllByHome_Id(Long home_id) {
        return imageHomeRepository.findAllByHome_Id(home_id);
    }
}
