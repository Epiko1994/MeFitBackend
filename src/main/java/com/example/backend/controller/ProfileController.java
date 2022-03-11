package com.example.backend.controller;

import com.example.backend.model.Profile;
import com.example.backend.repository.ProfileRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/profile")
@RestController
@Tag(name = "Profile")
public class ProfileController {

    final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all Profiles")
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get profile by ID")
    public Profile getProfileById(@PathVariable int id){
        Optional<Profile> profileExist = profileRepository.findById(id);
        return profileExist.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Create profile - returns created profile if success, else null")
    public Profile createProfile(@RequestBody Profile profile) {
        // Missing check if exist functionality.
        /*
        Optional<Profile> profileExist = profileRepository.findByEmail(profile.getEmail);
        if(profileExist.isEmpty()){
            return profileRepository.save(profile);
        }
        return null;
        */
        return profileRepository.save(profile);
    }

}
