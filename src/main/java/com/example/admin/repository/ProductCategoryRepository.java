package com.example.admin.repository;


import com.example.admin.entity.ProductCategoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategoryDocument,String> {

}
