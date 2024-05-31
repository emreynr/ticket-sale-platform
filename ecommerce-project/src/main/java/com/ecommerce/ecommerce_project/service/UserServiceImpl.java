package com.ecommerce.ecommerce_project.service;

import com.ecommerce.ecommerce_project.dao.UserRepository;
import com.ecommerce.ecommerce_project.entity.User;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public User findById(int userId) {

        Optional<User> user = userRepository.findById(userId);

        User theUser = null;

        if (user.isPresent()) {
            theUser = user.get();
        }
        else {
            throw new RuntimeException("User not found with provided id :" + userId);
        }

        return  theUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User theUser) {

        userRepository.save(theUser);
    }

    @Override
    public void updateUser(User updateUser) {

        userRepository.save(updateUser);
    }

    @Override
    public void deleteById(int userId) {

        userRepository.deleteById(userId);
    }
}
