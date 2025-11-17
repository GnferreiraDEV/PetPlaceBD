package com.mycompany.controller;

import com.mycompany.service.ServicoService;
import com.mycompany.model.Servico;
import java.util.List;

public class ServicoController {

    private final ServicoService service = new ServicoService();

    public void cadastrar(String descricao, double preco, boolean banho, boolean tosa) {
        service.cadastrarServico(descricao, preco, banho, tosa);
    }

    public void listar() {
        List<Servico> lista = service.listar();

        for (Servico s : lista) {
            System.out.println(
                s.getIdServico() + " | " +
                s.getDescricao() + " | R$" +
                s.getPreco() + " | Banho: " +
                s.isBanho() + " | Tosa: " +
                s.isTosa()
            );
        }
    }

    public Servico buscar(String id) {
        return service.buscarPorId(id);
    }

    public void atualizar(String id, String descricao, double preco, boolean banho, boolean tosa) {
        service.atualizarServico(id, descricao, preco, banho, tosa);
    }

    public void deletar(String id) {
        service.deletarServico(id);
    }
}
