package com.example.admin.repository;


import com.example.admin.entity.BlogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<BlogDocument, String> {

}
