package com.example.admin.repository;

import com.example.admin.entity.CategoryDocument;
import com.example.admin.entity.SubCategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CategoryRepository extends MongoRepository<CategoryDocument,String> {
    @Query("{'name' : ?0}")
    CategoryDocument findByName(String name);
}
