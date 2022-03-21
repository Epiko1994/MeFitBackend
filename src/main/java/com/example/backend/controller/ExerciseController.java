package com.example.backend.controller;

import com.example.backend.model.Exercise;
import com.example.backend.model.User;
import com.example.backend.repository.ExerciseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/exercise")
@RestController
@Tag(name = "Exercise")
public class ExerciseController {
    final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @CrossOrigin
    @GetMapping("")
    @Operation(summary = "Get all exercises")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Get exercise by its ID")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Integer id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if(exercise.isEmpty()) return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(exercise.get());
    }

    @CrossOrigin
    @PostMapping("")
    @Operation(summary = "Create an exercise")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        Exercise newExercise = exerciseRepository.save(exercise);
        return ResponseEntity.created(URI.create("/exercise/" + newExercise.getId())).body(newExercise);
    }
}
