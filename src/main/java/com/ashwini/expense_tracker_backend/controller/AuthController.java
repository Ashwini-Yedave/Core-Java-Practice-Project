package com.ashwini.expense_tracker_backend.controller;

import com.ashwini.expense_tracker_backend.dto.LoginRequest;
import com.ashwini.expense_tracker_backend.dto.SignupRequest;
import com.ashwini.expense_tracker_backend.entity.User;
import com.ashwini.expense_tracker_backend.services.AuthService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest request) {

        return authService.signup(request);
    }

    // LOGIN
    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody LoginRequest request) {

        String token = authService.login(request);

        return Map.of(
                "token", token
        );
    }
}