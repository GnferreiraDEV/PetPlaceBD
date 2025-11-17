package com.mycompany.service;

import com.mycompany.dao.AgendamentoDAO;
import com.mycompany.model.Agendamento;
import java.util.List;
import java.util.UUID;

public class AgendamentoService {

    private final AgendamentoDAO dao = new AgendamentoDAO();

    // CREATE
    public void criarAgendamento(String cpf, String idServico, String data, String hora,
                                 String formaPagamento, double valor) {

        Agendamento ag = new Agendamento();
        ag.setIdAgendamento(UUID.randomUUID().toString());
        ag.setCpfCliente(cpf);
        ag.setIdServico(idServico);
        ag.setDataAgendamento(data);
        ag.setHoraAgendamento(hora);
        ag.setFormaPagamento(formaPagamento);
        ag.setValor(valor);
        ag.setStatus("AGENDADO");

        dao.salvar(ag);
    }

    // READ
    public Agendamento buscarPorId(String id) {
        return dao.buscarPorId(id);
    }

    public List<Agendamento> listarTodos() {
        return dao.listarTodos();
    }

    // UPDATE
    public void atualizarAgendamento(Agendamento ag) {
        dao.atualizar(ag);
    }

    // DELETE
    public void deletarAgendamento(String id) {
        dao.deletar(id);
    }
}
