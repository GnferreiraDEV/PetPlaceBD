package com.mycompany.controller;

import com.mycompany.model.Agendamento;
import com.mycompany.service.AgendamentoService;
import java.util.List;

public class AgendamentoController {

    private final AgendamentoService service = new AgendamentoService();

    // CREATE
    public void agendar(String cpf, String idServico, String data, String hora,
                        String formaPagamento, double valor) {
        service.criarAgendamento(cpf, idServico, data, hora, formaPagamento, valor);
    }

    // READ
    public Agendamento buscar(String id) {
        return service.buscarPorId(id);
    }

    public List<Agendamento> listar() {
        return service.listarTodos();
    }

    // UPDATE
    public void atualizar(String id, String cpf, String idServico, String data, String hora,
                          String formaPagamento, double valor, String status) {

        Agendamento a = new Agendamento(id, cpf, idServico, data, hora, valor, formaPagamento, status);
        service.atualizarAgendamento(a);
    }

    // DELETE
    public void deletar(String id) {
        service.deletarAgendamento(id);
    }

    // LISTAR formatado (bonitão no console)
    public void listarFormatado() {
        List<Agendamento> lista = service.listarTodos();

        for (Agendamento a : lista) {
            System.out.println(
                a.getIdAgendamento() + " | " +
                a.getCpfCliente() + " | " +
                a.getIdServico() + " | " +
                a.getDataAgendamento() + " " + a.getHoraAgendamento() + " | " +
                a.getValor() + " | " +
                a.getFormaPagamento() + " | " +
                a.getStatus()
            );
        }
    }
}
