package com.bank.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.model.User;
import com.bank.api.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserService {
    
	UserRepository userRepo;

    public UserService(){
        this.userRepo = new UserRepository();
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        // User savedUser = userRepo.save(user);
        // return savedUser;
        return user;
    }
}
