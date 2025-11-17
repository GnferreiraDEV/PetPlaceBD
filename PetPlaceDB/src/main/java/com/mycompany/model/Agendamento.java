package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento {

    @Id // 3. Chave Primária
    @Column(name = "idAGENDAMENTO") // Liga 'idAgendamento' com 'idAGENDAMENTO'
    private String idAgendamento;

    @Column(name = "CPF_CLIENTE") // Liga com a coluna do banco
    private String cpfCliente;

    @Column(name = "SERVICO_idSERVICO") // ATENÇÃO: No seu SQL está assim
    private String idServico;

    @Column(name = "DATA_AGENDAMENTO")
    private String dataAgendamento;

    @Column(name = "HORA_AGENDAMENTO")
    private String horaAgendamento;

    @Column(name = "VALOR")
    private double valor;

    @Column(name = "FORMA_PAGAMENTO")
    private String formaPagamento;

    @Column(name = "STATUS")
    private String status;

    // Construtor Vazio (Obrigatório para o JPA)
    public Agendamento() {}

    // Construtor Cheio
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

    // Getters e Setters (Iguais ao que você já tinha)
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