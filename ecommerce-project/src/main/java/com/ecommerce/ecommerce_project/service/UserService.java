package com.ecommerce.ecommerce_project.service;

import com.ecommerce.ecommerce_project.entity.User;

import java.util.List;

public interface UserService {

    User findById(int userId);
    List<User> findAll();


    void createUser(User theUser);


    void updateUser(User updateUser);


    void deleteById(int userId);
}
