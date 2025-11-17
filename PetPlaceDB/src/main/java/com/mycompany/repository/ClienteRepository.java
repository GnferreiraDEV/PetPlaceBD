package com.mycompany.repository;

import com.mycompany.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository; // Importe o JpaRepository
import org.springframework.stereotype.Repository;

@Repository // 1. Diz ao Spring que esta é uma interface de Repositório
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    // 2. A MÁGICA ESTÁ AQUI
    // (Pode deixar o corpo da interface VAZIO)
}