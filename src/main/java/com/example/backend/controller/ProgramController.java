package com.example.backend.controller;

import com.example.backend.model.Program;
import com.example.backend.model.Workout;
import com.example.backend.repository.ProgramRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/program")
@RestController
@Tag(name = "program")
public class ProgramController {
    final ProgramRepository programRepository;

    public ProgramController(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all programs")
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a program by id")
    public Program getProgramById(@PathVariable Integer id) {
        Optional<Program> program = programRepository.findById(id);
        return program.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Create a new program")
    public Program createProgram(@RequestBody Program program) {
        return programRepository.save(program);
    }
}
