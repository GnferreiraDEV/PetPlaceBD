package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private String idCompra;
    private String cpfCliente;
    private double valorTotal;
    private List<ItemCompra> itens = new ArrayList<>();

    public String getIdCompra() { return idCompra; }
    public void setIdCompra(String idCompra) { this.idCompra = idCompra; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public List<ItemCompra> getItens() { return itens; }
    public void addItem(ItemCompra item) { this.itens.add(item); }
}
