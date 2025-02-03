package com.example.admin.dto;

public class LoginResponse {
    private String jwt_token;
    private String username;
    private String role;
    public LoginResponse(String username, String jwt_token) {
        this.username = username;
        this.jwt_token = jwt_token;
    }

    public LoginResponse () {

    }

    public String getJwt_token () {
        return jwt_token;
    }

    public void setJwt_token (String jwt_token) {
        this.jwt_token = jwt_token;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getRole () {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }
}
