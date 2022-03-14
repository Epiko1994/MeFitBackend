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
    @Column(name = "profile_id")
    private Integer profileId;

    @OneToOne
    private User userId;

    @OneToOne
    private Address addresses;

    @JsonGetter("programs")
    public List<String> programsGetter() {
        if(programs != null) {
            return programs.stream()
                    .map(program -> {
                        return "/program/" + program.getProgramId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @OneToMany(mappedBy = "profile")
    @Column(name = "program_id")
    private List<Program> programs = new ArrayList<>();

    @JsonGetter("workouts")
    public List<String> workoutsGetter() {
        if(workouts != null) {
            return workouts.stream()
                    .map(workout -> {
                        return "/workout/" + workout.getWorkoutId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @OneToMany(mappedBy = "profile")
    @Column(name = "workout_id")
    private List<Workout> workouts = new ArrayList<>();

    @JsonGetter("sets")
    public List<String> setsGetter() {
        if(sets != null) {
            return sets.stream()
                    .map(set -> {
                        return "/set/" + set.getSetId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

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
