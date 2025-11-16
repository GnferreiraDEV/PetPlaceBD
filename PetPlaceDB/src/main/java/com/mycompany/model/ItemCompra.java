package com.mycompany.model;

public class ItemCompra {

    private String idProduto;
    private int quantidade;

    public ItemCompra(String idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public String getIdProduto() { return idProduto; }
    public int getQuantidade() { return quantidade; }
}
