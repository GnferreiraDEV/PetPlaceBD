package com.mycompany.model;

public class ItemCompra {

    private String idProduto;
    private int quantidade;

    public ItemCompra() {}

    public ItemCompra(String idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public String getIdProduto() { return idProduto; }
    public void setIdProduto(String idProduto) { this.idProduto = idProduto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}