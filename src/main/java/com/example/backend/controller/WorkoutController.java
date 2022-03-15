package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.model.Workout;
import com.example.backend.repository.WorkoutRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/workout")
@RestController
@Tag(name = "Workout")
public class WorkoutController {
    final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("")
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(@PathVariable Integer id) {
        Optional<Workout> workout = workoutRepository.findById(id);
        return workout.orElse(null);
    }

    @PostMapping("")
    public Workout createWorkout(@RequestBody Workout workout) {
        Optional<Workout> workoutExist = workoutRepository.findByName(workout.getName());
        if(workoutExist.isEmpty()) {
            return workoutRepository.save(workout);
        }
        return null;
    }
}
