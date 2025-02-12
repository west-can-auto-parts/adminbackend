package com.example.admin.controller;

import com.example.admin.dto.AdminUserRequest;
import com.example.admin.dto.AdminUserResponse;
import com.example.admin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-users")
@CrossOrigin(origins = "*")
public class AdminUserController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<AdminUserResponse>> getAllAdminUsers() {
        return ResponseEntity.ok(profileService.getAllAdminUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUserResponse> getAdminUserById(@PathVariable String id) {
        AdminUserResponse response = profileService.getAdminUserById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        profileService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdminUser(@RequestBody AdminUserRequest adminUserRequest) {
        String message = profileService.updateAdminUser(adminUserRequest);
        return ResponseEntity.ok(message);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createAdminUser(@RequestBody AdminUserRequest adminUserRequest) {
        try {
            AdminUserResponse response = profileService.createAdminProfile(adminUserRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the admin user.");
        }
    }
}
