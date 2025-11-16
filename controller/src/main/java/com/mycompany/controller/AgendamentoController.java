/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.service.AgendamentoService;

/**
 *
 * @author Gustavo
 */
public class AgendamentoController {

    private final AgendamentoService service = new AgendamentoService();

    public void agendar(
            String cpf,
            String idServico,
            String data,
            String hora,
            String formaPagamento,
            double valor
    ) {
        service.criarAgendamento(cpf, idServico, data, hora, formaPagamento, valor);
    }
}
    

