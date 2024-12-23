package com.example.admin.dto;

import java.util.Date;
import java.util.List;

public class BlogRequest {
    private String title;
    private String content;
    private String imageUrl;
    private List<String> categories;
    private List<String> tags;
    private String authorName;
    private String authorLinkedin;
    private Date updatedAt;


    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
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

    public List<String> getTags () {
        return tags;
    }

    public void setTags (List<String> tags) {
        this.tags = tags;
    }

    public String getAuthorName () {
        return authorName;
    }

    public void setAuthorName (String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLinkedin () {
        return authorLinkedin;
    }

    public void setAuthorLinkedin (String authorLinkedin) {
        this.authorLinkedin = authorLinkedin;
    }

    public Date getUpdatedAt () {
        return updatedAt;
    }

    public void setUpdatedAt (Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
