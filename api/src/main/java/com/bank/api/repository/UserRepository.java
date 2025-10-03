package com.bank.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bank.api.model.User;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.addAll(UserDataInitializer.getUsers());
    }
    

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User save(User user) {
        Optional<User> existing = getUserById(user.getId());

        if (existing.isPresent()) {
            User u = existing.get();
            u.setName(user.getName());
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPhone(user.getPhone());
            u.setWebsite(user.getWebsite());
            return u;
        } else {
            users.add(user);
            return user;
        }
    }
}
