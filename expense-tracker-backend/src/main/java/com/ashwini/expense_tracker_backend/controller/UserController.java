package com.ashwini.expense_tracker_backend.controller;

import com.ashwini.expense_tracker_backend.entity.User;
import com.ashwini.expense_tracker_backend.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ADD USER API

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}