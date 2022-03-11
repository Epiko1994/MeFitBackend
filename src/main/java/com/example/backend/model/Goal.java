package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Integer goalId;

    @ManyToMany(mappedBy = "goals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Workout> workouts = new ArrayList<>();

    private Date endDate;

    private boolean achieved;

    public Goal() {}

    public Integer getGoalId() {
        return goalId;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isAchieved() {
        return achieved;
    }
}
