package com.example.admin.controller;

import com.example.admin.config.CustomUserDetails;
import com.example.admin.config.JwtUtils;
import com.example.admin.dto.LoginRequest;
import com.example.admin.dto.LoginResponse;
import com.example.admin.dto.SignUpRequest;
import com.example.admin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        LoginResponse response=authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest){
        String response=authService.signup(signUpRequest);
        return ResponseEntity.ok().body(response);
    }

}
