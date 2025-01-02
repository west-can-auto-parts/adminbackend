package com.example.admin.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "Contact")
public class ContactDocument {
    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phoneNumber;
    private String message;
    private boolean agreed;
    private Date createdAt;

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
        return company;
    }

    public void setCompanyName (String companyName) {
        this.company = company;
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

    public Date getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (Date createdAt) {
        this.createdAt = createdAt;
    }
}
