package com.example.admin.dto;

import java.util.List;
import java.util.Map;

public class SupplierDtoRequest {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> Category;
    private Map<String,Integer> subCategoryAndPosition;
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

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getCategory () {
        return Category;
    }

    public void setCategory (List<String> category) {
        Category = category;
    }

    public Map<String, Integer> getSubCategoryAndPosition () {
        return subCategoryAndPosition;
    }

    public void setSubCategoryAndPosition (Map<String, Integer> subCategoryAndPosition) {
        this.subCategoryAndPosition = subCategoryAndPosition;
    }

    public List<String> getProductCategory () {
        return productCategory;
    }

    public void setProductCategory (List<String> productCategory) {
        this.productCategory = productCategory;
    }
}
