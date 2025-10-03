package com.bank.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserService {
    
    @GetMapping("/")
    public String helloWorld() {
        return new String("Hello World");
    }
}
