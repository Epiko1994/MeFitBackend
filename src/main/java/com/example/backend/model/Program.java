package com.example.backend.model;

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
    @ManyToMany(mappedBy = "programs")
    private List<Profile> profiles;


    @ManyToMany(mappedBy = "programs")
    private List<Workout> workouts;

    private String name;

    private String category;

    public Program() {}

    public Integer getId() {
        return id;
    }

    public List<Profile> getProfile() {
        return profiles;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
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
