package com.example.admin.dto;

import lombok.Data;

import java.util.Date;


public class ContactResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String message;
    private boolean agreed;
    private String createdAt;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName () {
        return companyName;
    }

    public void setCompanyName (String companyName) {
        this.companyName = companyName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public boolean isAgreed () {
        return agreed;
    }

    public void setAgreed (boolean agreed) {
        this.agreed = agreed;
    }

    public String getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (String createdAt) {
        this.createdAt = createdAt;
    }
}
