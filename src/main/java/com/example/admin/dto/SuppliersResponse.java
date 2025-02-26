package com.example.admin.dto;

import java.util.List;
import java.util.Map;

public class SuppliersResponse {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> category;
    private Map<String,Integer> subCategoryAndPosition;
    private List<String> productCategory;

    public SuppliersResponse(String id, String name, String description, String imageUrl, List<String> category, Map<String, Integer> subCategoryAndPosition, List<String> productCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.subCategoryAndPosition = subCategoryAndPosition;
        this.productCategory = productCategory;
    }

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
        return category;
    }

    public void setCategory (List<String> category) {
        this.category = category;
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

    public SuppliersResponse(String id, String name,String description ,String logoUrl) {
        this.id = id;
        this.name = name;
        this.description=description;
//        this.category = category;
//        this.subcategory = subcategory;
//        this.productCategory = productCategory;
        this.imageUrl = logoUrl;
    }
    public SuppliersResponse(){

    }
}
