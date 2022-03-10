package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue
    @Column(name = "program_id")
    private Integer programId;

    @ManyToOne
    private Profile profile;

    @ManyToMany(mappedBy = "programs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Workout> workouts;

    private String name;

    private String category;

    public Program() {}
}
