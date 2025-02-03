package com.example.admin.service.implementation;

import com.example.admin.config.CustomUserDetails;
import com.example.admin.config.JwtUtils;
import com.example.admin.dto.LoginRequest;
import com.example.admin.dto.LoginResponse;
import com.example.admin.dto.SignUpRequest;
import com.example.admin.entity.AdminUserDocument;
import com.example.admin.repository.AdminUserRepository;
import com.example.admin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtil.generateTokenFromRole(customUserDetails);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(userDetails.getName());
        loginResponse.setJwt_token(jwtToken);
        loginResponse.setRole(userDetails.getRole());

        return loginResponse;
    }

    @Override
    public String signup(SignUpRequest signUpRequest) {

        if(adminUserRepository.findByEmail(signUpRequest.getEmail())!=null){
            throw new RuntimeException("Email already exist");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        AdminUserDocument adminUserDocument = new AdminUserDocument();
        adminUserDocument.setEmail(signUpRequest.getEmail());
        adminUserDocument.setName(signUpRequest.getName());
        adminUserDocument.setPassword(hashedPassword);
        adminUserDocument.setRole(signUpRequest.getRole());

         adminUserRepository.save(adminUserDocument);
        return "user successfully created.";
    }
}
