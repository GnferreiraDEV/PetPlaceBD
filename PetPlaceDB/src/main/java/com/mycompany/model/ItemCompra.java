package com.mycompany.model;

// Esta classe serve apenas para transportar dados (DTO),
// pois mapear a tabela COMPRA_has_PRODUTO com chave composta é complexo no JPA iniciante.
public class ItemCompra {

    private String idProduto;
    private int quantidade;

    // Construtor vazio é necessário para o JSON funcionar
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