package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICO")
public class Servico {

    @Id
    @Column(name = "idSERVICO")
    private String idServico;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO")
    private double preco;

    @Column(name = "BANHO")
    private boolean banho;

    @Column(name = "TOSA")
    private boolean tosa;

    public Servico() {}

    // Cole seus construtores e Getters/Setters abaixo...
    public Servico(String idServico, String descricao, double preco, boolean banho, boolean tosa) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.preco = preco;
        this.banho = banho;
        this.tosa = tosa;
    }

    public String getIdServico() { return idServico; }
    public void setIdServico(String idServico) { this.idServico = idServico; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public boolean isBanho() { return banho; }
    public void setBanho(boolean banho) { this.banho = banho; }

    public boolean isTosa() { return tosa; }
    public void setTosa(boolean tosa) { this.tosa = tosa; }
}