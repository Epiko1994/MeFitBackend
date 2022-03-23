package com.example.backend.controller;

import com.example.backend.model.Profile;
import com.example.backend.repository.ProfileRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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
    public Profile getProfileById(@PathVariable Integer id){
        Optional<Profile> profileExist = profileRepository.findById(id);
        return profileExist.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Create profile")
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

    @DeleteMapping
    @Operation(summary = "Delete a profile (including user and address) by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User was successfully deleted"),
            @ApiResponse(responseCode = "404", description = "User was not found")
    })
    public ResponseEntity<Profile> deleteUser(@RequestBody Profile profile) {
        Optional<Profile> profileOptional = profileRepository.findById(profile.getId());
        if(profileOptional.isEmpty()) return ResponseEntity.notFound().build();
        profileRepository.delete(profileOptional.get());
        return ResponseEntity.ok().build();
    }

}
