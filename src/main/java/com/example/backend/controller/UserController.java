package com.example.backend.controller;

import com.example.backend.model.Profile;
import com.example.backend.model.User;
import com.example.backend.repository.ProfileRepository;
import com.example.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get a user by email, else null")
    public User getUserByEmail(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Register a user with empty profile - Returns the new user if saved successful, else null")
    public User registerUser(@RequestBody User user) {
        Optional<User> userExist = userRepository.findByEmail(user.getEmail());
        if(userExist.isEmpty()) {
            Profile profile = new Profile(user);
            profileRepository.save(profile);
            return userRepository.getById(profile.getUserId());
        }
        return null;
    }

    @PostMapping("/login")
    @Operation(summary = "Send a login request (checks if e-mail exists) - Returns user if found, else null")
    public User loginUser(@RequestBody User user) {
        Optional<User> userRequest = userRepository.findByEmail(user.getEmail());
        return userRequest.orElse(null);
    }
}
