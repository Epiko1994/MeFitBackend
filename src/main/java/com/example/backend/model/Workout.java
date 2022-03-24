package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToMany(mappedBy = "workouts")
    private List<Profile> profiles;

    @ManyToMany
    private List<Set> sets = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "workouts")
    private List<Goal> goals = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "workouts")
    private List<Program> programs = new ArrayList<>();

    private String name;

    private String type;

    private boolean complete = false;

    public Workout() {}

    public Integer getId() {
        return id;
    }

    public List<Set> getSets() {
        return sets;
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
