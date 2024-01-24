package com.example.spring_crud.services;

import com.example.spring_crud.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);
}
