package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @Column(name = "goal_id")
    private UUID goalId = UUID.randomUUID();
}
