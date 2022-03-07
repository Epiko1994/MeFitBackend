package com.example.backend.controller;

import com.example.backend.model.Profile;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/profile")
@RestController
@Tag(name = "Profile")
public class ProfileController {

    @GetMapping("")
    public List<Profile> getAllProfiles() {
        return null;
    }

    @PostMapping("")
    public void createProfile(@RequestBody Profile profile) {

    }

}
