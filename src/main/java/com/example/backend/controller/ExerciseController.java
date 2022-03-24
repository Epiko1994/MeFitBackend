package com.example.backend.controller;

import com.example.backend.model.Exercise;
import com.example.backend.repository.ExerciseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all exercises")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }

    @CrossOrigin
    @PostMapping("")
    @Operation(summary = "Create an exercise, returns location (URI) ")
    @ApiResponse(responseCode = "201", description = "Successfully created")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        Exercise newExercise = exerciseRepository.save(exercise);
        return ResponseEntity.created(URI.create("/exercise/" + newExercise.getId())).build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Get exercise by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Exercise with ID, was not found")
    })
    public ResponseEntity<Exercise> getExerciseById(@PathVariable int id) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
        if(exerciseOptional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(exerciseOptional.get());
    }

    @CrossOrigin
    @PatchMapping("")
    @Operation(summary = "Update exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Exercise with ID, was not found")
    })
    public ResponseEntity<Exercise> updateExerciseById(@RequestBody Exercise exercise){
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exercise.getId());
        if(exerciseOptional.isEmpty()) return ResponseEntity.notFound().build();
        else {
            Exercise updateExercise = exerciseOptional.get();
            if(exercise.getDescription() != null) updateExercise.setDescription(exercise.getDescription());
            if(exercise.getImage() != null) updateExercise.setImage(exercise.getImage());
            if(exercise.getName() != null) updateExercise.setName(exercise.getName());
            if(exercise.getTargetMuscleGroup() != null) updateExercise.setTargetMuscleGroup(exercise.getTargetMuscleGroup());
            if(exercise.getVideoLink() != null) updateExercise.setVideoLink(exercise.getVideoLink());

            return ResponseEntity.ok(exerciseRepository.save(updateExercise));
        }
    }

    @CrossOrigin
    @DeleteMapping("")
    @Operation(summary = "Delete exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Exercise with ID, was not successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Exercise with ID, was not found")
    })
    public ResponseEntity<Exercise> deleteExerciseById(@RequestBody Exercise exercise){
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exercise.getId());
        if(exerciseOptional.isEmpty()) return ResponseEntity.notFound().build();
        exerciseRepository.delete(exercise);

        // checks if exercise was deleted.
        exerciseOptional = exerciseRepository.findById(exercise.getId());
        if(exerciseOptional.isPresent()) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }
}
