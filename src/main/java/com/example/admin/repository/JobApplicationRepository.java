package com.example.admin.repository;

import com.example.admin.entity.JobApplicationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobApplicationRepository extends MongoRepository<JobApplicationDocument, String> {
}
