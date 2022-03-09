package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("")
    public void registerUser() {
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody User user) {

    }
}
