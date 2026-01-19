package com.iuc.event_management.service;

import com.iuc.event_management.config.JwtUtils;
import com.iuc.event_management.dto.request.LoginRequest;
import com.iuc.event_management.dto.request.RegisterRequest;
import com.iuc.event_management.dto.response.JwtResponse;
import com.iuc.event_management.entity.Role;
import com.iuc.event_management.entity.User;
import com.iuc.event_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepository userRepo,
                       PasswordEncoder encoder,
                       JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    public JwtResponse login(LoginRequest request) {

        User user = userRepo.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String roles = user.getRoles()
                .stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));

        String token = jwtUtils.generateToken(user.getEmail(), roles);
        return new JwtResponse(token, roles);
    }

    public void register(RegisterRequest request) {

        if (userRepo.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(encoder.encode(request.password));

        // rôle par défaut
        user.setRoles(Set.of(Role.USER));

        userRepo.save(user);
    }
}
