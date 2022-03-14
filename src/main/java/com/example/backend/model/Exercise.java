package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer exerciseId;

    @ManyToOne
    private Set set;

    private String name;

    private String description;

    private String targetMuscleGroup;

    private String image;

    private String videoLink;

    public Exercise() {}

    public Integer getExerciseId() {
        return exerciseId;
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
