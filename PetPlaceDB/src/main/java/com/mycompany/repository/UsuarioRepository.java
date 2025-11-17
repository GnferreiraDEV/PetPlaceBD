package com.mycompany.repository;

import com.mycompany.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // Método extra para o Login funcionar (Busca por email/login)
    Usuario findByLogin(String login);
}