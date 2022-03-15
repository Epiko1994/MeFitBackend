package com.example.backend.repository;

import com.example.backend.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goal, Integer> {
}
