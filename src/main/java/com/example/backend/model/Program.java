package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Integer programId;

    @ManyToOne
    private Profile profile;

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

    @ManyToMany(mappedBy = "programs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Workout> workouts;

    private String name;

    private String category;

    public Program() {}

    public Integer getProgramId() {
        return programId;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
