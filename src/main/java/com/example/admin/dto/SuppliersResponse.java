package com.example.admin.dto;

import java.util.List;

public class SuppliersResponse {
    private String id;
    private String name;
    private String logoUrl;
    private List<String> category;
    private List<String> subcategory;
    private List<String> productCategory;

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

    public String getLogoUrl () {
        return logoUrl;
    }

    public void setLogoUrl (String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<String> getCategory () {
        return category;
    }

    public void setCategory (List<String> category) {
        this.category = category;
    }

    public List<String> getSubcategory () {
        return subcategory;
    }

    public void setSubcategory (List<String> subcategory) {
        this.subcategory = subcategory;
    }

    public List<String> getProductCategory () {
        return productCategory;
    }

    public void setProductCategory (List<String> productCategory) {
        this.productCategory = productCategory;
    }
    public SuppliersResponse(String id, String name, List<String> category, List<String> subcategory, List<String> productCategory, String logoUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
        this.productCategory = productCategory;
        this.logoUrl = logoUrl;
    }
}
