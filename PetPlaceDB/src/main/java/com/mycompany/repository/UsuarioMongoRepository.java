package com.mycompany.repository;

import com.mycompany.model.UsuarioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioMongoRepository extends MongoRepository<UsuarioMongo, String> {
}