package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetMuscleGroup(String targetMuscleGroup) {
        this.targetMuscleGroup = targetMuscleGroup;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}
