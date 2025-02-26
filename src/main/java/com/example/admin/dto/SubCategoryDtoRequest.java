package com.example.admin.dto;

import java.util.List;
import java.util.Map;

public class SubCategoryDtoRequest {
    private String name;
    private String description;
    private String categoryId;
    private List<String> images;
    private List<String> tags;
    private boolean featured;
    private boolean bestSeller;
    private Map<String,Integer> productCategoryAndPosition;

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

    public String getCategoryId () {
        return categoryId;
    }

    public void setCategoryId (String categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getImages () {
        return images;
    }

    public void setImages (List<String> images) {
        this.images = images;
    }

    public List<String> getTags () {
        return tags;
    }

    public void setTags (List<String> tags) {
        this.tags = tags;
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

    public Map<String, Integer> getProductCategoryAndPosition () {
        return productCategoryAndPosition;
    }

    public void setProductCategoryAndPosition (Map<String, Integer> productCategoryAndPosition) {
        this.productCategoryAndPosition = productCategoryAndPosition;
    }
}
