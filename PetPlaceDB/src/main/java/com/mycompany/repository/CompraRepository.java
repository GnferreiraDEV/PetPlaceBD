package com.mycompany.repository;

import com.mycompany.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {

    // Esse método insere o item na tabela de ligação "na força bruta" (SQL Nativo)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO COMPRA_has_PRODUTO (COMPRA_idCOMPRA, PRODUTO_idPRODUTO, QUANTIDADE) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void salvarItemCompra(String idCompra, String idProduto, int quantidade);
}