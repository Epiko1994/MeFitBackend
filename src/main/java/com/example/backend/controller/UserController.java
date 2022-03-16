package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/user")
@RestController
@Tag(name = "User")
public class UserController {

    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID, else null")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get a user by email, else null")
    public User getUserById(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @PostMapping("")
    @Operation(summary = "Register a user - Returns the new user if saved successful, else null")
    public User registerUser(@RequestBody User user) {
        Optional<User> userExist = userRepository.findByEmail(user.getEmail());
        if(userExist.isEmpty()) {
            return userRepository.save(user);
        }
        return null;
    }

    @PostMapping("/login")
    @Operation(summary = "Send a login request - Returns user if found, else null")
    public User loginUser(@RequestBody User user) {
        Optional<User> userRequest = userRepository.findById(user.getId());
        return userRequest.orElse(null);
    }
}
