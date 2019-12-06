package com.hotel.demo.service;

import com.hotel.demo.model.User;

public interface UserService {
    Iterable<User> findAll();

    Iterable<User> findUsersByNameContaining(String user_name);
}
