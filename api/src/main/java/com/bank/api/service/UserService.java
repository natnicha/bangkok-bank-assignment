package com.bank.api.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.model.User;
import com.bank.api.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserService {
    
	UserRepository userRepo;

    public UserService(){
        this.userRepo = new UserRepository();
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userRepo.addUser(user);
        return ResponseEntity.created(URI.create("/user" + user.getId()))
                .body(user); 
    }
}
