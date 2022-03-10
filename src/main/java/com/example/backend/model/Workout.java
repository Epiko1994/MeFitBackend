package com.example.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue
    @Column(name = "workout_id")
    private Integer workoutId;

    @ManyToOne
    private Profile profile;

    @OneToMany(mappedBy = "workout")
    @Column(name = "sets")
    private List<Set> sets = new ArrayList<>();

    @ManyToMany
    private List<Goal> goals = new ArrayList<>();

    @ManyToMany
    private List<Program> programs = new ArrayList<>();

    private String name;

    private String type;

    private boolean complete = false;

    public Workout() {}

    public Integer getWorkoutId() {
        return workoutId;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Set> getSets() {
        return sets;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isComplete() {
        return complete;
    }
}
