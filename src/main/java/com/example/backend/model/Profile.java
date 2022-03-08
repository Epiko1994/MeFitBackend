package com.example.backend.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column(name = "profile_id")
    @Type(type = "uuid-char")
    private UUID profileId = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

    @OneToMany
    @JoinColumn(name = "goal_id", referencedColumnName = "goal_id")
    private List<Goal> goals;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address addresses;

    @OneToMany
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    private List<Program> programs;

    @OneToMany
    @JoinColumn(name = "workout_id", referencedColumnName = "workout_id")
    private List<Workout> workouts;

    @OneToMany
    @JoinColumn(name = "set_id", referencedColumnName = "set_id")
    private List<Set> sets;

    private Double weight;

    private Double height;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    private String disabilities;
}
