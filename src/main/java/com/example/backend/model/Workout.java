package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Integer workoutId;

    @ManyToOne
    private Profile profile;

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

    @OneToMany(mappedBy = "workout")
    @Column(name = "sets")
    private List<Set> sets = new ArrayList<>();

    @JsonGetter("goals")
    public List<String> goalsGetter() {
        if(goals != null) {
            return goals.stream()
                    .map(goal -> {
                        return "/goal/" + goal.getGoalId();
                    }).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @ManyToMany
    private List<Goal> goals = new ArrayList<>();

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
