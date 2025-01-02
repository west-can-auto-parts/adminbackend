package com.example.admin.repository;

import com.example.admin.entity.ProductEnquiryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductEnquiryRepository extends MongoRepository<ProductEnquiryDocument,String> {
}
