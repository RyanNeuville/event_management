package com.iuc.event_management.controller;
import com.iuc.event_management.dto.request.LoginRequest;
import com.iuc.event_management.dto.request.RegisterRequest;
import com.iuc.event_management.dto.response.JwtResponse;
import com.iuc.event_management.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        service.register(request);
    }
}
