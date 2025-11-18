package com.mycompany.repository;

import com.mycompany.model.ClienteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteMongoRepository extends MongoRepository<ClienteMongo, String> {
}