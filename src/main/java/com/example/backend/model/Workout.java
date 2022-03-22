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

    @OneToMany(mappedBy = "workout")
    private List<Set> sets = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<Goal> goals = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<Program> programs = new ArrayList<>();

    private String name;

    private String type;

    private boolean complete = false;

    public Workout() {}

    public Integer getId() {
        return id;
    }

    public List<Profile> getProfile() {
        return profiles;
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

//    @JsonGetter("goals")
//    public List<String> goalsGetter() {
//        if(goals != null) {
//            return goals.stream()
//                    .map(goal -> {
//                        return "/goal/" + goal.getId();
//                    }).collect(Collectors.toList());
//        } else {
//            return null;
//        }
//    }
//
//    @JsonGetter("programs")
//    public List<String> programsGetter() {
//        if(programs != null) {
//            return programs.stream()
//                    .map(program -> {
//                        return "/program/" + program.getId();
//                    }).collect(Collectors.toList());
//        } else {
//            return null;
//        }
//    }

//    @JsonGetter("sets")
//    public List<String> setsGetter() {
//        if(sets != null) {
//            return sets.stream()
//                    .map(set -> {
//                        return "/set/" + set.getId();
//                    }).collect(Collectors.toList());
//        } else {
//            return null;
//        }
//    }
}
