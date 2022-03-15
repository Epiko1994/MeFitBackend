package com.example.backend.controller;

import com.example.backend.model.Goal;
import com.example.backend.repository.GoalsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/goals")
@RestController
@Tag(name = "Goals")
public class GoalsController {

    final GoalsRepository goalsRepository;

    public GoalsController(GoalsRepository goalsRepository) {
        this.goalsRepository = goalsRepository;
    }

    @GetMapping("")
    public List<Goal> getAllGoal() {
        return goalsRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get goal by ID")
    public Goal getGoalById(@PathVariable Integer id){
        Optional<Goal> goalExist = goalsRepository.findById(id);
        return goalExist.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Creates a new goal")
    public Goal createGoal(@RequestBody Goal goal) {
        return goalsRepository.save(goal);
    }
}
