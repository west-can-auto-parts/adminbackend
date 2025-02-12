package com.example.admin.service.implementation;

import com.example.admin.dto.AdminUserRequest;
import com.example.admin.dto.AdminUserResponse;
import com.example.admin.entity.AdminUserDocument;
import com.example.admin.repository.AdminUserRepository;
import com.example.admin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public List<AdminUserResponse> getAllAdminUser() {
        return adminUserRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AdminUserResponse getAdminUserById(String id) {
        Optional<AdminUserDocument> adminUser = adminUserRepository.findById(id);
        return adminUser.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteAdmin(String id) {
        adminUserRepository.deleteById(id);
    }

    @Override
    public String updateAdminUser(AdminUserRequest adminUserRequest) {
        Optional<AdminUserDocument> existingAdmin = adminUserRepository.findById(adminUserRequest.getId());
        if (existingAdmin.isPresent()) {
            AdminUserDocument admin = existingAdmin.get();
            admin.setName(adminUserRequest.getName());
            admin.setEmail(adminUserRequest.getEmail());
            admin.setPassword(adminUserRequest.getPassword());
            admin.setRole(adminUserRequest.getRole());
            adminUserRepository.save(admin);
            return "Admin user updated successfully";
        }
        return "Admin user not found";
    }

    @Override
    public AdminUserResponse createAdminProfile(AdminUserRequest adminUserRequest) {
        // Validate request
        if (adminUserRequest.getEmail() == null || adminUserRequest.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (adminUserRequest.getPassword() == null || adminUserRequest.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        if (adminUserRepository.findByEmail(adminUserRequest.getEmail())!=null) {
            throw new IllegalArgumentException("Email already exists");
        }
        AdminUserDocument adminUser = new AdminUserDocument();
        adminUser.setId(adminUserRequest.getId());
        adminUser.setName(adminUserRequest.getName());
        adminUser.setEmail(adminUserRequest.getEmail());
        adminUser.setRole(adminUserRequest.getRole());
        adminUser.setPassword(new BCryptPasswordEncoder().encode(adminUserRequest.getPassword())); // Encrypt password

        AdminUserDocument savedAdmin = adminUserRepository.save(adminUser);

        return new AdminUserResponse(
                savedAdmin.getId(),
                savedAdmin.getName(),
                savedAdmin.getEmail(),
                savedAdmin.getRole()
        );
    }

    private AdminUserResponse mapToResponse(AdminUserDocument adminUser) {
        return new AdminUserResponse(adminUser.getId(), adminUser.getEmail(), adminUser.getName(), adminUser.getRole());
    }
}
