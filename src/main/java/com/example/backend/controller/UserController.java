package com.example.backend.controller;

import com.example.backend.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/User")
@RestController
@Tag(name = "User")
public class UserController {

    @GetMapping("")
    public List<User> getAllUsers() {
        return null;
    }

    @PostMapping("")
    public void registerUser() {
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody User user) {

    }
}
