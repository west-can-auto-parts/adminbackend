package com.example.admin.repository;

import com.example.admin.entity.PublicUserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicUserRepository extends MongoRepository<PublicUserDocument,String> {
}
