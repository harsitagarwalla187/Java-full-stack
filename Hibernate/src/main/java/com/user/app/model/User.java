package com.user.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "my_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, email, address;

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
//        this.id = email.length();
    }
}
