package com.example.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PublicUser")
public class PublicUserDocument {
    private String id;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
    private String nearestStore;
    private String signUpMethod;
    private String resetToken;

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

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getNearestStore () {
        return nearestStore;
    }

    public void setNearestStore (String nearestStore) {
        this.nearestStore = nearestStore;
    }

    public String getSignUpMethod () {
        return signUpMethod;
    }

    public void setSignUpMethod (String signUpMethod) {
        this.signUpMethod = signUpMethod;
    }

    public String getResetToken () {
        return resetToken;
    }

    public void setResetToken (String resetToken) {
        this.resetToken = resetToken;
    }
}
