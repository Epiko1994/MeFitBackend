package com.example.backend.controller;

import com.example.backend.model.Profile;
import com.example.backend.model.User;
import com.example.backend.repository.ProfileRepository;
import com.example.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/user")
@RestController
@Tag(name = "User")
public class UserController {

    final ProfileRepository profileRepository;
    final UserRepository userRepository;

    public UserController(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID, else null")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found and returned"),
            @ApiResponse(responseCode = "404", description = "User was not found")
    })
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }

    @GetMapping("email/{email}")
    @Operation(summary = "Get a user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found and returned"),
            @ApiResponse(responseCode = "404", description = "User was not found")
    })
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("")
    @Operation(summary = "Register a user with empty profile - Returns path to new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User was successfully created"),
            @ApiResponse(responseCode = "400", description = "User could not be created - user probably already exist")
    })
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        Optional<User> userExist = userRepository.findByEmail(user.getEmail());
        if(userExist.isEmpty()) {
            Profile profile = new Profile(user);
            profileRepository.save(profile);
            return ResponseEntity.created(URI.create("/user/" + profile.getUserId())).build();
        }
        return ResponseEntity.badRequest().build();
    }

    //TODO: Probably not a useful endpoint - does the same as getUserByEmail
    @PostMapping("/login")
    @Operation(summary = "Send a login request (checks if e-mail exists)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User was successfully found"),
            @ApiResponse(responseCode = "404", description = "User was not found")
    })
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userOptional.get());
    }

    @DeleteMapping
    @Operation(summary = "Delete a user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User was successfully deleted"),
            @ApiResponse(responseCode = "404", description = "User was not found")
    })
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();
        userRepository.delete(userOptional.get());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("")
    @Operation(summary = "Update an existing user with new values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User was successfully found and updated"),
            @ApiResponse(responseCode = "404", description = "User was not found")
    })
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();
        else{
            User updateUser = userOptional.get();
            updateUser.setId(user.getId());
            if(user.getEmail() != null){
                 updateUser.setEmail(user.getEmail());
            }
            if(user.getProfile() != null){
                updateUser.setProfile(user.getProfile());
            }
            if(user.getFirstName() != null){
               updateUser.setFirstName(user.getFirstName());
            }

            if(user.getPassword() != null){
                updateUser.setPassword(user.getPassword());
            }
            if(user.getLastName() != null){
                updateUser.setLastName(user.getLastName());
            }

            return ResponseEntity.ok(userRepository.save(updateUser));
        }
    }
}
