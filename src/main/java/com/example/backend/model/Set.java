package com.example.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sets")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToMany(mappedBy = "sets")
    private List<Profile> profiles;

    @OneToMany(mappedBy = "set")
    private List<Exercise> exercises = new ArrayList<>();

    @ManyToMany(mappedBy = "sets")
    private List<Workout> workouts;

    private Integer exerciseRepetitions;

    public Set() {}

    public Integer getId() {
        return id;
    }
    public List<Exercise> getExercises() {
        return exercises;
    }
    public Integer getExerciseRepetitions() {
        return exerciseRepetitions;
    }
}
