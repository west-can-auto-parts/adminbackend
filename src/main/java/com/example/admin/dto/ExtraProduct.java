package com.example.admin.dto;

import java.util.List;

public class ExtraProduct {
    private String name;
    private String description;
    private List<String> imageUrl;
    private List<String> tags;

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
}
