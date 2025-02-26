package com.example.admin.repository;

import com.example.admin.entity.SuppliersDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SuppliersRepository extends MongoRepository<SuppliersDocument,String> {

    @Query("{ 'name': { '$regex': ?0, '$options': 'i' } }")
    SuppliersDocument findByName (String name);

    @Query("{ '_id': ?0}")
    SuppliersDocument getById (String id);
}
