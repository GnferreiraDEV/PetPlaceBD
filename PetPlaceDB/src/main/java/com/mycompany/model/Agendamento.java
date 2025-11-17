/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Gustavo
 */
public class Agendamento {
    private String idAgendamento;
    private String cpfCliente;
    private String idServico;
    private String dataAgendamento;
    private String horaAgendamento;
    private double valor;
    private String formaPagamento;
    private String status;

    public Agendamento() {}

    public Agendamento(String idAgendamento, String cpfCliente, String idServico, String dataAgendamento,
                       String horaAgendamento, double valor, String formaPagamento, String status) {
        this.idAgendamento = idAgendamento;
        this.cpfCliente = cpfCliente;
        this.idServico = idServico;
        this.dataAgendamento = dataAgendamento;
        this.horaAgendamento = horaAgendamento;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public String getIdAgendamento() { return idAgendamento; }
    public void setIdAgendamento(String idAgendamento) { this.idAgendamento = idAgendamento; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public String getIdServico() { return idServico; }
    public void setIdServico(String idServico) { this.idServico = idServico; }

    public String getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(String dataAgendamento) { this.dataAgendamento = dataAgendamento; }

    public String getHoraAgendamento() { return horaAgendamento; }
    public void setHoraAgendamento(String horaAgendamento) { this.horaAgendamento = horaAgendamento; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
