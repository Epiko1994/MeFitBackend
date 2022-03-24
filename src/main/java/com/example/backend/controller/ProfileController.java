package com.example.backend.controller;

import com.example.backend.model.Profile;
import com.example.backend.repository.ProfileRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileRepository.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get profile by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile found and returned"),
            @ApiResponse(responseCode = "404", description = "Profile was not found")
    })
    public ResponseEntity<Profile> getProfileById(@PathVariable Integer id){
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if(profileOptional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(profileOptional.get());
    }

//    @PostMapping("")
//    @Operation(summary = "Create profile")
//    public Profile createProfile(@RequestBody Profile profile) {
//        // Missing check if exist functionality.
//        /*
//        Optional<Profile> profileExist = profileRepository.findByEmail(profile.getEmail);
//        if(profileExist.isEmpty()){
//            return profileRepository.save(profile);
//        }
//        return null;
//        */
//        return profileRepository.save(profile);
//    }

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

    @PatchMapping
    @Operation(summary = "Update an existing profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile was successfully found and updated"),
            @ApiResponse(responseCode = "403", description = "Changing user/address information is not allowed"),
            @ApiResponse(responseCode = "404", description = "Profile was not found")
    })
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        Optional<Profile> profileOptional = profileRepository.findById(profile.getId());
        if(profileOptional.isEmpty()) return ResponseEntity.notFound().build();
        else{
            if(profile.getUser() != null) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            if(profile.getAddress() != null) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            Profile updateProfile = profileOptional.get();
            if(profile.getDisabilities() != null) updateProfile.setDisabilities(profile.getDisabilities());
            if(profile.getHeight() != null) updateProfile.setHeight(profile.getHeight());
            if(profile.getMedicalConditions() != null) updateProfile.setMedicalConditions(profile.getMedicalConditions());
            if(profile.getWeight() != null) updateProfile.setWeight(profile.getWeight());

            return ResponseEntity.ok(profileRepository.save(updateProfile));
        }
    }
}
