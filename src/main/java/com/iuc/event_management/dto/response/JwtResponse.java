package com.iuc.event_management.dto.response;

public class JwtResponse {
    public String token;
    public String role;
    public JwtResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
