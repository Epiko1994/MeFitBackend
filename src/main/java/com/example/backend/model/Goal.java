package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue
    @Column(name = "goal_id")
    private Integer goalId;

    @ManyToMany(mappedBy = "goals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Workout> workouts = new ArrayList<>();

    private LocalDateTime endDate;

    private boolean achieved;

    public Goal() {}
}
