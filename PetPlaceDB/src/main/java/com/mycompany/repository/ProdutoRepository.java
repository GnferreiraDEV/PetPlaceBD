package com.mycompany.repository;

import com.mycompany.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 1. Diz ao Spring que este é um Repositório
public interface ProdutoRepository extends JpaRepository<Produto, String> {
    // 2. Pode deixar o corpo VAZIO!
    // O Spring cria os métodos:
    // save(), findById(), findAll(), deleteById(), etc.
}