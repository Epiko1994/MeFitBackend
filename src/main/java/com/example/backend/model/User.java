package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Integer getUserId() {
        return userId;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isContributor() {
        return isContributor;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
