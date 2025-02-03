package com.example.admin.service.implementation;

import com.example.admin.config.CustomUserDetails;
import com.example.admin.entity.AdminUserDocument;
import com.example.admin.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUserDocument user = adminUserRepository.findByEmail(username);  // Assuming findByEmail is defined in your repository
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new CustomUserDetails(user); // Wrap the PublicUserDocument in CustomUserDetails
    }
}