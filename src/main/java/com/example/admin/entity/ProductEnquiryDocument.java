package com.example.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ProductEnquiryForm")
public class ProductEnquiryDocument {
    private String id;
    private String name;
    private String email;
    private String store;
    private List<String> productName;
    private String message;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getStore () {
        return store;
    }

    public void setStore (String store) {
        this.store = store;
    }

    public List<String> getProductName () {
        return productName;
    }

    public void setProductName (List<String> productName) {
        this.productName = productName;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}