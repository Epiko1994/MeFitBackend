package com.example.backend.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Integer addressId;

    @ManyToOne
    private Set set;

    private String name;

    private String description;

    private String targetMuscleGroup;

    private String image;

    private String videoLink;

    public Exercise() {}
}
