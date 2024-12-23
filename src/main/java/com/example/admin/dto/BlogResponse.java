package com.example.admin.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


public class BlogResponse {

    private String id;
    private String title;
    private String content;
    private String imageUrl;
    private List<String> categories;
    private List<String> tags;
    private String authorName;
    private String authorLinkedin;
    private Date createdAt;
    private boolean featured;
    private boolean newBlog;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

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

    public Date getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isFeatured () {
        return featured;
    }

    public void setFeatured (boolean featured) {
        this.featured = featured;
    }

    public boolean isNewBlog () {
        return newBlog;
    }

    public void setNewBlog (boolean newBlog) {
        this.newBlog = newBlog;
    }
}
