package com.example.backend.controller;

import com.example.backend.model.Set;
import com.example.backend.repository.SetRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/set")
@RestController
@Tag(name = "Set")
public class SetController {
    final SetRepository setRepository;

    public SetController(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all sets")
    public List<Set> getAllSets() { return setRepository.findAll(); }


    @GetMapping("/{id}")
    @Operation(summary = "Get set by id")
    public Set getSetById(@PathVariable Integer id) {
        Optional<Set> set = setRepository.findById(id);
        return set.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Create new set")
    public Set createSet(@RequestBody Set set){
        return setRepository.save(set);
    }
}
