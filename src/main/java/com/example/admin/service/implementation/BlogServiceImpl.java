package com.example.admin.service.implementation;

import com.example.admin.dto.BlogRequest;
import com.example.admin.dto.BlogResponse;
import com.example.admin.entity.BlogDocument;
import com.example.admin.repository.BlogRepository;
import com.example.admin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<BlogResponse> fetchAllBlog () {
        List<BlogDocument> blogDocData=blogRepository.findAll();
        List<BlogResponse> blogResponseList=new ArrayList<>();
        for(BlogDocument bg:blogDocData){
            BlogResponse bgRes=new BlogResponse();
            bgRes.setId(bg.getId());
            bgRes.setTitle(bg.getTitle());
            bgRes.setContent(bg.getContent());
            bgRes.setImageUrl(bg.getImageUrl());
            bgRes.setCategories(bg.getCategories());
            bgRes.setTags(bg.getTags());
            bgRes.setAuthorName(bg.getAuthorName());
            bgRes.setAuthorLinkedin(bg.getAuthorLinkedin());
            bgRes.setCreatedAt(bg.getCreatedAt());
            bgRes.setFeatured(bg.isFeatured());
            bgRes.setNewBlog(bg.isNewBlog());
            blogResponseList.add(bgRes);
        }
        return blogResponseList;
    }

    @Override
    public BlogResponse fetchById (String id) {
        Optional<BlogDocument> blogDocument=blogRepository.findById(id);
        if(blogDocument.isEmpty()){
            return null;
        }
        BlogDocument bugDocument=blogDocument.get();
        BlogResponse blogResponse=new BlogResponse();
        blogResponse.setId(bugDocument.getId());
        blogResponse.setNewBlog(bugDocument.isNewBlog());
        blogResponse.setContent(bugDocument.getContent());
        blogResponse.setCategories(bugDocument.getCategories());
        blogResponse.setTags(bugDocument.getTags());
        blogResponse.setTitle(bugDocument.getTitle());
        blogResponse.setAuthorName(bugDocument.getAuthorName());
        blogResponse.setAuthorLinkedin(bugDocument.getAuthorLinkedin());
        blogResponse.setCreatedAt(bugDocument.getCreatedAt());
        blogResponse.setFeatured(bugDocument.isFeatured());
        return blogResponse;
    }

    @Override
    public String updateById (String id, BlogRequest blogRequest) {
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        Date date = Date.from(currentDateTime.toInstant());
        Optional<BlogDocument> blogDocument=blogRepository.findById(id);
        if(blogDocument.isEmpty()){
            return null;
        }
        BlogDocument bugDocument = getBlogDocument(blogRequest, blogDocument, date);
        blogRepository.save(bugDocument);

        return "Blog update successfully";
    }

    private static BlogDocument getBlogDocument (BlogRequest blogRequest, Optional<BlogDocument> blogDocument, Date date) {
        BlogDocument bugDocument= blogDocument.get();
        bugDocument.setTitle(blogRequest.getTitle());
        bugDocument.setContent(blogRequest.getContent());
        bugDocument.setImageUrl(blogRequest.getImageUrl());
        bugDocument.setCategories(blogRequest.getCategories());
        bugDocument.setTags(blogRequest.getTags());
        bugDocument.setAuthorName(blogRequest.getAuthorName());
        bugDocument.setAuthorLinkedin(blogRequest.getAuthorLinkedin());
        bugDocument.setUpdatedAt(date);
        return bugDocument;
    }
}
