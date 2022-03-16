package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonGetter("programs")
    public List<String> programsGetter() {
        if(programs != null) {
            return programs.stream()
                    .map(program -> {
                        return "/program/" + program.getId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @OneToMany(mappedBy = "profile")
    private List<Program> programs = new ArrayList<>();

    @JsonGetter("workouts")
    public List<String> workoutsGetter() {
        if(workouts != null) {
            return workouts.stream()
                    .map(workout -> {
                        return "/workout/" + workout.getId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @OneToMany(mappedBy = "profile")
    private List<Workout> workouts = new ArrayList<>();

    @JsonGetter("sets")
    public List<String> setsGetter() {
        if(sets != null) {
            return sets.stream()
                    .map(set -> {
                        return "/set/" + set.getId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @OneToMany(mappedBy = "profile")
    private List<Set> sets = new ArrayList<>();

    private Double weight;

    private Double height;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    private String disabilities;

    public Profile() {}

    public Profile(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return user.getId();
    }

    public Integer getAddressId() {
        return address.getId();
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
