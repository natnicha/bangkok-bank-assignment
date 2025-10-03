package com.bank.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    public User(Long id, String name, String username, String email, String phone, String website) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }
}
