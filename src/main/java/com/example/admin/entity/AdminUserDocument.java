package com.example.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "AdminUser")
public class AdminUserDocument implements UserDetails {
    private String id;
    private String email;
    private String name;
    private String password;
    private String role;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return List.of();
    }

    public String getPassword () {
        return password;
    }

    @Override
    public String getUsername () {
        return "";
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getRole () {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }
}
