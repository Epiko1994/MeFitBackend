package com.example.backend.repository;

import com.example.backend.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
    Optional<Workout> findByName(String name);
}
