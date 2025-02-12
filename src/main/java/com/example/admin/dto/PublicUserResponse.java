package com.example.admin.dto;

public class PublicUserResponse {
    private String id;
    private String email;
    private String name;
    private String phoneNumber;
    private String address;
    private String nearestStore;
    private String signUpMethod;

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
}
