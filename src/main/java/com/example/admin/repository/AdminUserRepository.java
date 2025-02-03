package com.example.admin.repository;

import com.example.admin.entity.AdminUserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends MongoRepository<AdminUserDocument,String> {
    @Query("{'email': ?0}")
    AdminUserDocument findByEmail(String email);
}
