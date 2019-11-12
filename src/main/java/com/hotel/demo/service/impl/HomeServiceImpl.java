package com.hotel.demo.service.impl;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.model.Home;
import com.hotel.demo.model.StatusHome;
import com.hotel.demo.repository.HomeRepository;
import com.hotel.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        homeRepository.deleteById(id);
    }

    @Override
    public void save(Home home) {
        homeRepository.save(home);
    }

    @Override
    public Iterable<Home> findAllByCategoryHome(CategoryHome categoryHome) {
        return homeRepository.findAllByCategoryHome(categoryHome);
    }

    @Override
    public Iterable<Home> findAllByCategoryRoom(CategoryRoom categoryRoom) {
        return homeRepository.findAllByCategoryRoom(categoryRoom);
    }

    @Override
    public Iterable<Home> findAllByStatusHome(StatusHome statusHome) {
        return homeRepository.findAllByStatusHome(statusHome);
    }
}
