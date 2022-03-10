package com.example.backend.controller;

import com.example.backend.model.Address;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/address")
@RestController
@Tag(name = "Address")
public class AddressController {
    @GetMapping("")
    public List<Address> getAllAddresses() {
        return null;
    }

    @PostMapping("")
    public void registerUser() {
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody Address address) {

    }
}
