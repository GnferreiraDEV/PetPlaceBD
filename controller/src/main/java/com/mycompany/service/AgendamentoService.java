/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.AgendamentoDAO;
import com.mycompany.model.Agendamento;
import java.util.UUID;

/**
 *
 * @author Karol
 */
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

        com.mycompany.dao.salvar(ag);
    }
    

