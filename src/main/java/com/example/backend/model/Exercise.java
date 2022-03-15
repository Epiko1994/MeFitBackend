package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set set;

    private String name;

    private String description;

    private String targetMuscleGroup;

    private String image;

    private String videoLink;

    public Exercise() {}

    public Integer getId() {
        return id;
    }

    public Set getSet() {
        return set;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public String getImage() {
        return image;
    }

    public String getVideoLink() {
        return videoLink;
    }
}
