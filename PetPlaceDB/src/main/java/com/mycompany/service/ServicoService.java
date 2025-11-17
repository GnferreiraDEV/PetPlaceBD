package com.mycompany.service;

import com.mycompany.dao.ServicoDAO;
import com.mycompany.model.Servico;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
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

    public Servico buscarPorId(String id) {
        return dao.buscarPorId(id);
    }

    public void atualizarServico(String id, String descricao, double preco, boolean banho, boolean tosa) {
        Servico existente = dao.buscarPorId(id);

        if (existente == null) {
            throw new RuntimeException("Serviço não encontrado para atualização!");
        }

        existente.setDescricao(descricao);
        existente.setPreco(preco);
        existente.setBanho(banho);
        existente.setTosa(tosa);

        dao.atualizar(existente);
    }

    public void deletarServico(String id) {
        dao.deletar(id);
    }
}
