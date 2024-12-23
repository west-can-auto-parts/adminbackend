package com.example.admin.repository;


import com.example.admin.entity.ProductCategoryDocument;
import com.example.admin.entity.SubCategoryDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategoryDocument, String> {
    @Query("{'name' : ?0}")
    SubCategoryDocument findByName(String name);
}
