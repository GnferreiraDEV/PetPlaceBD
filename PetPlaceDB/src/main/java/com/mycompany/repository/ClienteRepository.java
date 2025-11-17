package com.mycompany.repository;

import com.mycompany.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    // MÁGICA DO SPRING:
    // Só de declarar isso, ele cria o SQL: SELECT * FROM CLIENTE WHERE EMAIL = ?
    Cliente findByEmail(String email);

}