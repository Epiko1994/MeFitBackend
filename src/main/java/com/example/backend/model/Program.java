package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany(mappedBy = "programs")
    private List<Workout> workouts;

    private String name;

    private String category;

    public Program() {}

    public Integer getId() {
        return id;
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

//    @JsonGetter("workouts")
//    public List<String> workoutsGetter() {
//        if(workouts != null) {
//            return workouts.stream()
//                    .map(workout -> {
//                        return "/workout/" + workout.getId();
//                    }).collect(Collectors.toList());
//        } else {
//            return null;
//        }
//    }
}
