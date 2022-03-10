package com.example.backend.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne
    private Profile profile;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private boolean isContributor = false;

    private boolean isAdmin = false;

    public User() {}
}
