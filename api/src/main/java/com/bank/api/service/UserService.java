package com.bank.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.model.User;

@RestController
@RequestMapping("/api/user")
public class UserService {
    
    @GetMapping("/")
    public String helloWorld() {
        return new String("Hello World");
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        // User savedUser = userRepo.save(user);
        // return savedUser;
        return user;
    }
}
