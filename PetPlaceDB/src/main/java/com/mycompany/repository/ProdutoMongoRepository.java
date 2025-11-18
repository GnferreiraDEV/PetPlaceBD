package com.mycompany.repository;

import com.mycompany.model.ProdutoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoMongoRepository extends MongoRepository<ProdutoMongo, String> {

}