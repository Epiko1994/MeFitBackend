package com.example.backend.controller;

import com.example.backend.model.Exercise;
import com.example.backend.model.User;
import com.example.backend.repository.ExerciseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Get exercise by its ID")
    public Exercise getExerciseById(@PathVariable Integer id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.orElse(null);
    }

    @CrossOrigin
    @PostMapping("")
    @Operation(summary = "Create an exercise")
    public Exercise createExercise(@RequestBody Exercise exercise) {
        Optional<Exercise> exerciseExist = exerciseRepository.findByName(exercise.getName());
        if(exerciseExist.isEmpty()) {
            return exerciseRepository.save(exercise);
        }
        return null;
    }
}
