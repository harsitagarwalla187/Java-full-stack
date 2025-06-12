package com.user.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return name + " " + email + " " + address;
    }
}
