package com.example.admin.repository;

import com.example.admin.entity.ContactDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends MongoRepository<ContactDocument,String> {
}
