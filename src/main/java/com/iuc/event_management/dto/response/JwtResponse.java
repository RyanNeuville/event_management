package com.iuc.event_management.dto.response;

public class JwtResponse {
    public String token;
    public String role;
    public JwtResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }
}
