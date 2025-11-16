package com.mycompany.model;

public class Servico {

    private String idServico;
    private String descricao;
    private double preco;
    private boolean banho;
    private boolean tosa;

    public Servico() {}

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
