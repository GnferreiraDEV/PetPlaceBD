package com.mycompany.repository;

import com.mycompany.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Diz ao Spring que este é um Repositório
public interface ServicoRepository extends JpaRepository<Servico, String> {
    // Pode deixar o corpo VAZIO!
    // O Spring cria os métodos:
    // save(), findById(), findAll(), deleteById(), etc.
}