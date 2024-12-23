package com.example.admin.service;

import com.example.admin.dto.BlogRequest;
import com.example.admin.dto.BlogResponse;

import java.util.List;

public interface BlogService {
    public List<BlogResponse> fetchAllBlog();
    public BlogResponse fetchById(String id);
    public String updateById(String id, BlogRequest blogRequest);
}
