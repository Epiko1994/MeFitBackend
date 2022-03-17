package com.example.backend.repository;

import com.example.backend.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set, Integer> {
}
