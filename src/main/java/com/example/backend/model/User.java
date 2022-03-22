package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private boolean isContributor = false;

    private boolean isAdmin = false;

    public User() {}

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContributor(boolean contributor) {
        isContributor = contributor;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
