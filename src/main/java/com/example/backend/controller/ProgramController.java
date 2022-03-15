package com.example.backend.controller;

import com.example.backend.model.Program;
import com.example.backend.model.Workout;
import com.example.backend.repository.ProgramRepository;
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
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Program getProgramById(@PathVariable Integer id) {
        Optional<Program> program = programRepository.findById(id);
        return program.orElse(null);
    }

    @PostMapping("")
    public Program createProgram(@RequestBody Program program) {
        Optional<Program> programExist = programRepository.findByName(program.getName());
        if(programExist.isEmpty()) {
            return programRepository.save(program);
        }
        return null;
    }
}
