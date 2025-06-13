package com.mapping.app.entity;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    public Passport passport;
}