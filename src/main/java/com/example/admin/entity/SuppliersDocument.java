package com.example.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Suppliers")
public class SuppliersDocument {
    private String id;
    private String name;
    private String imageUrl;
    private List<String> categories;
    private List<String> subCategories;
    private List<String> productCategories;

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

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getCategories () {
        return categories;
    }

    public void setCategories (List<String> categories) {
        this.categories = categories;
    }

    public List<String> getSubCategories () {
        return subCategories;
    }

    public void setSubCategories (List<String> subCategories) {
        this.subCategories = subCategories;
    }

    public List<String> getProductCategories () {
        return productCategories;
    }

    public void setProductCategories (List<String> productCategories) {
        this.productCategories = productCategories;
    }
}
