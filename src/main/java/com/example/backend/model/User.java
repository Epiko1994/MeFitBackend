package com.example.backend.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {
    @Id
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID userId = UUID.randomUUID();

    public User() {}
}
