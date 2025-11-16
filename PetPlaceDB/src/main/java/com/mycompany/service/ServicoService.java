package com.mycompany.service;

import com.mycompany.dao.ServicoDAO;
import com.mycompany.model.Servico;

import java.util.List;
import java.util.UUID;

public class ServicoService {

    private final ServicoDAO dao = new ServicoDAO();

    public void cadastrarServico(String descricao, double preco, boolean banho, boolean tosa) {

        String id = "SERV_" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);

        Servico s = new Servico(id, descricao, preco, banho, tosa);

        dao.salvar(s);
    }

    public List<Servico> listar() {
        return dao.listarTodos();
    }
}
