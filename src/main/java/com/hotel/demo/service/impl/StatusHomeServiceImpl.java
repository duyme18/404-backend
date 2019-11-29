package com.hotel.demo.service.impl;

import com.hotel.demo.model.StatusHome;
import com.hotel.demo.repository.StatusHomeRepository;
import com.hotel.demo.service.StatusHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusHomeServiceImpl implements StatusHomeService {
    @Autowired
    private StatusHomeRepository statusHomeRepository;

    @Override
    public Iterable<StatusHome> findAll() {
        return statusHomeRepository.findAll();
    }

    @Override
    public Optional<StatusHome> findById(Long id) {
        return statusHomeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        statusHomeRepository.deleteById(id);
    }

    @Override
    public void save(StatusHome statusHome) {
        statusHomeRepository.save(statusHome);
    }
}
