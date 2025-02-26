package com.example.admin.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "ProductCategory")
public class ProductCategoryDocument {
    private String id;
    private String name;
    private String description;
    private List<String> imageUrl;
    private String categoryId;
    private String subCategoryId;
    private List<String> tags;
    private boolean featured;
    private boolean bestSeller;
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

    public List<String> getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTags () {
        return tags;
    }

    public void setTags (List<String> tags) {
        this.tags = tags;
    }

    public String getCategoryId () {
        return categoryId;
    }

    public void setCategoryId (String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryId () {
        return subCategoryId;
    }

    public void setSubCategoryId (String subCategoryId) {
        this.subCategoryId = subCategoryId;
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

    public Map<String, Integer> getBrandAndPosition () {
        return brandAndPosition;
    }

    public void setBrandAndPosition (Map<String, Integer> brandAndPosition) {
        this.brandAndPosition = brandAndPosition;
    }
}
