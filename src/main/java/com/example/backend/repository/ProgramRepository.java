package com.example.backend.repository;

import com.example.backend.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    Optional<Program> findByName(String name);
}
