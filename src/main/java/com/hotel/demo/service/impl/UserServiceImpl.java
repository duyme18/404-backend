package com.hotel.demo.service.impl;

import com.hotel.demo.model.User;
import com.hotel.demo.repository.UserRepository;
import com.hotel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findUsersByNameContaining(String user_name) {
        return userRepository.findUsersByNameContaining(user_name);
    }
}
