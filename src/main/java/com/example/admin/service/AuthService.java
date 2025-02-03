package com.example.admin.service;

import com.example.admin.dto.LoginRequest;
import com.example.admin.dto.LoginResponse;
import com.example.admin.dto.SignUpRequest;

public interface AuthService {
    public String signup(SignUpRequest sign);
    public LoginResponse login(LoginRequest loginRequest);
}
