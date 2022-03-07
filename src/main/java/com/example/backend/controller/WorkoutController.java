package com.example.backend.controller;

import com.example.backend.model.Workout;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/workout")
@RestController
@Tag(name = "Workout")
public class WorkoutController {
    @GetMapping("")
    public List<Workout> getAllWorkouts() {
        return null;
    }

    @PostMapping("")
    public void createWorkout(@RequestBody Workout workout) {

    }
}
