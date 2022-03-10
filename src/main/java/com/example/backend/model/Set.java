package com.example.backend.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sets")
public class Set {
    @Id
    @GeneratedValue
    @Column(name = "set_id")
    private Integer setId;

    @ManyToOne
    private Profile profile;

    @OneToMany(mappedBy = "set")
    @Column(name = "exercises")
    private List<Exercise> exercises = new ArrayList<>();

    @ManyToOne
    private Workout workout;

    private Integer exerciseRepetitions;

    public Set() {}
}
