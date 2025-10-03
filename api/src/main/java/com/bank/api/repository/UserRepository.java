package com.bank.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bank.api.model.User;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        // Initialize with provided user list
        users.addAll(UserDataInitializer.getUsers());
    }
    

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
