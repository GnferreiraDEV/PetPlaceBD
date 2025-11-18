package com.mycompany.repository;

import com.mycompany.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List; // <--- Importante: Adicione este import!

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {

    // 1. Método para salvar itens (Já existia e está correto)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO COMPRA_has_PRODUTO (COMPRA_idCOMPRA, PRODUTO_idPRODUTO, QUANTIDADE) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void salvarItemCompra(String idCompra, String idProduto, int quantidade);

    // 2. NOVO MÉTODO: Buscar compras por CPF (Para o filtro de permissão)
    // O Spring Data cria o SQL automaticamente baseado no nome "findByCpfCliente"
    List<Compra> findByCpfCliente(String cpfCliente);
}