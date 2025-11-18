package com.mycompany.repository;

import com.mycompany.model.ProdutoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoMongoRepository extends MongoRepository<ProdutoMongo, String> {
    // Não precisa escrever nada aqui, ele já vem com save(), findAll(), etc.

    // Opcional: Se quiser buscar pelo ID do MySQL no futuro
    // ProdutoMongo findByIdMysql(String idMysql);
}