package com.example.backend.controller;

import com.example.backend.model.Exercise;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/exercise")
@RestController
@Tag(name = "Exercise")
public class ExerciseController {
    @CrossOrigin(origins = "https://mefitbackend-ajlm.herokuapp.com")
    @GetMapping("")
    public List<Exercise> getAllExercises() {
        return null;
    }

    @PostMapping("")
    public void createExercise(@RequestBody Exercise exercise) {

    }
}
