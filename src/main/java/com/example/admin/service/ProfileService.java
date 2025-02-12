package com.example.admin.service;

import com.example.admin.dto.AdminUserRequest;
import com.example.admin.dto.AdminUserResponse;

import java.util.List;

public interface ProfileService {
    List<AdminUserResponse> getAllAdminUser();
    AdminUserResponse getAdminUserById(String id);
    void deleteAdmin(String id);
    String updateAdminUser(AdminUserRequest adminUserRequest);
    AdminUserResponse createAdminProfile(AdminUserRequest adminUserRequest);
}
