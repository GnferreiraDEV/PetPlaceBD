package com.mycompany.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPRA")
public class Compra {

    @Id
    @Column(name = "idCOMPRA")
    private String idCompra;

    @Column(name = "CPF") // FK para Cliente
    private String cpfCliente;

    @Column(name = "DATA_COMPRA")
    private String dataCompra; // Ou use LocalDate se preferir

    @Column(name = "VALOR_TOTAL")
    private double valorTotal;

    // @Transient significa: O JPA ignora isso na hora de ler a tabela COMPRA direto.
    // Nós usaremos isso apenas para receber o JSON do front-end.
    @Transient
    private List<ItemCompra> itens = new ArrayList<>();

    // --- Construtores ---
    public Compra() {}

    public Compra(String idCompra, String cpfCliente, String dataCompra, double valorTotal) {
        this.idCompra = idCompra;
        this.cpfCliente = cpfCliente;
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
    }

    // --- Getters e Setters ---
    public String getIdCompra() { return idCompra; }
    public void setIdCompra(String idCompra) { this.idCompra = idCompra; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public String getDataCompra() { return dataCompra; }
    public void setDataCompra(String dataCompra) { this.dataCompra = dataCompra; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public List<ItemCompra> getItens() { return itens; }
    public void setItens(List<ItemCompra> itens) { this.itens = itens; }

    public void addItem(ItemCompra item) { this.itens.add(item); }
}