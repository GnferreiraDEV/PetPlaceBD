package com.mycompany.service;

import com.mycompany.dao.AgendamentoDAO;
import com.mycompany.model.Agendamento;
import java.util.UUID;

public class AgendamentoService {

    private final AgendamentoDAO dao = new AgendamentoDAO();

    public void criarAgendamento(
            String cpf,
            String idServico,
            String data,
            String hora,
            String formaPagamento,
            double valor
    ) {
        Agendamento ag = new Agendamento();

        ag.setId(UUID.randomUUID().toString());
        ag.setCpfCliente(cpf);
        ag.setIdServico(idServico);
        ag.setData(data);
        ag.setHora(hora);
        ag.setFormaPagamento(formaPagamento);
        ag.setValor(valor);
        ag.setStatus("AGENDADO");

        dao.salvar(ag);
    }
}
