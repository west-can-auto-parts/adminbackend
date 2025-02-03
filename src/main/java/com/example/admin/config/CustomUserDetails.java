package com.example.admin.config;

import com.example.admin.entity.AdminUserDocument;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final AdminUserDocument adminUserDocument;

    public CustomUserDetails(AdminUserDocument adminUserDocument) {
        this.adminUserDocument = adminUserDocument;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming roles are not part of your PublicUserDocument, using a default role (e.g., ROLE_USER)
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); // Modify this if you have roles
    }

    @Override
    public String getPassword() {
        return adminUserDocument.getPassword();
    }

    @Override
    public String getUsername() {
        return adminUserDocument.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Implement your custom logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Implement your custom logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Implement your custom logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // Implement your custom logic if needed
    }

    public AdminUserDocument getPublicUserDocument() {
        return adminUserDocument;
    }
    public String getName() {
        return adminUserDocument.getName();  // Extracting name directly from PublicUserDocument
    }
    public String getEmail(){
        return adminUserDocument.getEmail();
    }
    public String getRole(){
        return adminUserDocument.getRole();
    }
}
