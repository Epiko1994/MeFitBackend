package com.example.backend.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue
    @Column(name = "profile_id")
    private Integer profileId;

    @OneToOne
    private User userId;

    @OneToOne
    private Address addresses;

    @OneToMany(mappedBy = "profile")
    @Column(name = "program_id")
    private List<Program> programs = new ArrayList<>();

    @OneToMany(mappedBy = "profile")
    @Column(name = "workout_id")
    private List<Workout> workouts = new ArrayList<>();

    @OneToMany(mappedBy = "profile")
    @Column(name = "set_id")
    private List<Set> sets = new ArrayList<>();

    private Double weight;

    private Double height;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    private String disabilities;

    public Profile() {}

    public Integer getProfileId() {
        return profileId;
    }

    public User getUserId() {
        return userId;
    }

    public Address getAddresses() {
        return addresses;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public List<Set> getSets() {
        return sets;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public String getDisabilities() {
        return disabilities;
    }
}
