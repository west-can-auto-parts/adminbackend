package com.example.admin.controller;

import com.example.admin.dto.BlogRequest;
import com.example.admin.dto.BlogResponse;
import com.example.admin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/api/blog")
public class BlogController {

   @Autowired
   private BlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<BlogResponse>> fetchBlog(){
        List<BlogResponse> blogResponseList=blogService.fetchAllBlog();
        return ResponseEntity.ok().body(blogResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogResponse> fetchById(@PathVariable ("id") String id){
        BlogResponse blogResponse=blogService.fetchById(id);
        return ResponseEntity.ok().body(blogResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable ("id") String id, @RequestBody BlogRequest blogRequest){
        String response= blogService.updateById(id,blogRequest);
        return ResponseEntity.ok().body(response);
    }
}
