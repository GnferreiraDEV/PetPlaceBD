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
    
    private String id;
    private String cpfCliente;
    private String idServico;
    private String data;
    private String hora;
    private String formaPagamento;
    private double valor;
    private String status;

    public Agendamento() {}

    // GETTERS e SETTERS

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public String getIdServico() { return idServico; }
    public void setIdServico(String idServico) { this.idServico = idServico; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
}
