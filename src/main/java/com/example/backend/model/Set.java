package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "sets")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @JsonGetter("exercises")
    public List<String> exercisesGetter() {
        if(exercises != null) {
            return exercises.stream()
                    .map(exercise -> {
                        return "/exercise/" + exercise.getId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @OneToMany(mappedBy = "set")
    private List<Exercise> exercises = new ArrayList<>();

    @ManyToOne
    private Workout workout;

    private Integer exerciseRepetitions;

    public Set() {}

    public Integer getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public Workout getWorkout() {
        return workout;
    }

    public Integer getExerciseRepetitions() {
        return exerciseRepetitions;
    }
}
