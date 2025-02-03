package com.example.admin.repository;

import com.example.admin.entity.JobOpening;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobOpeningRepository extends MongoRepository<JobOpening,String> {
}
