package com.example.backend.controller;

import com.example.backend.model.Goal;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/goals")
@RestController
@Tag(name = "Goals")
public class GoalsController {

    @GetMapping("")
    public List<Goal> getAllGoal() {
        return null;
    }

    @PostMapping("")
    public void createGoal(@RequestBody Goal goal) {

    }
}
