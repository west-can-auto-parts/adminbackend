package com.example.admin.repository;

import com.example.admin.entity.SubscribeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscribeRepository extends MongoRepository<SubscribeDocument,String> {
}
