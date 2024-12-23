package com.example.admin.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "SubCategory")
public class SubCategoryDocument {
    private String id;
    private String name;
    private String description;
    private String categoryId;
    private List<String> images;
    private List<String> tags;
    private boolean featured;
    private boolean bestSeller;

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

    public List<String> getImages () {
        return images;
    }

    public void setImages (List<String> images) {
        this.images = images;
    }

    public String getCategoryId () {
        return categoryId;
    }

    public void setCategoryId (String categoryId) {
        this.categoryId = categoryId;
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
}
