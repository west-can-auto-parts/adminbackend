package com.example.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "TempSuppliers")
public class SuppliersDocument {
    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private List<String> category;
    private Map<String,Integer> subCategoryAndPosition;
    private List<String> productCategory;

    public SuppliersDocument(String id, String name, String description, String imageUrl, List<String> category, Map<String, Integer> subCategoryAndPosition, List<String> productCategory) {
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

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
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
}
