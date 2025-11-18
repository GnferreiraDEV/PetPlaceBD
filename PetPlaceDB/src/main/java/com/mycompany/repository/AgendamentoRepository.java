package com.mycompany.repository;

import com.mycompany.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {

    List<Agendamento> findByCpfCliente(String cpfCliente);
}