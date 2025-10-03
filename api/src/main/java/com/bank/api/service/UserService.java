package com.bank.api.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.model.User;
import com.bank.api.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/{userId}")
    public ResponseEntity<?> getMethodName(@PathVariable String userId) {
        try {
            long id = Long.parseLong(userId);
            System.out.println(id);
            Optional<User> user = userRepo.getUserById(id);

            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("User not found with id: " + id);
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid userId: " + userId);
        }
    }

    @PutMapping("/{userId}")
public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
    Optional<User> existingUser = userRepo.getUserById(userId);

    if (existingUser.isPresent()) {
        User user = existingUser.get();

        user.setName(updatedUser.getName());
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setWebsite(updatedUser.getWebsite());

        userRepo.save(user);

        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found with id: " + userId);
    }
}


}
