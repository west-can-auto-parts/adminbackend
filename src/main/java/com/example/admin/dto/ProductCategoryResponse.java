package com.example.admin.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;


public class ProductCategoryResponse {
    private String id;
    private String name;
    private String description;
    private List<String> imageUrl;
    private List<String> tags;
    private String categoryName;
    private String subCategoryName;
    private boolean featured;
    private boolean bestSeller;
    private Integer productPosition;
    private Map<String,Integer> brandAndPosition;

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

    public List<String> getTags () {
        return tags;
    }

    public void setTags (List<String> tags) {
        this.tags = tags;
    }

    public String getCategoryName () {
        return categoryName;
    }

    public void setCategoryName (String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName () {
        return subCategoryName;
    }

    public void setSubCategoryName (String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public boolean isFeatured () {
        return featured;
    }

    public void setFeatured (boolean featured) {
        this.featured = featured;
    }

    public boolean isBestSeller () {
        return bestSeller;
    }

    public void setBestSeller (boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public List<String> getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getProductPosition () {
        return productPosition;
    }

    public void setProductPosition (Integer productPosition) {
        this.productPosition = productPosition;
    }

    public Map<String, Integer> getBrandAndPosition () {
        return brandAndPosition;
    }

    public void setBrandAndPosition (Map<String, Integer> brandAndPosition) {
        this.brandAndPosition = brandAndPosition;
    }
}
