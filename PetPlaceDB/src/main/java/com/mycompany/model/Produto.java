package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @Column(name = "idPRODUTO")
    private String idProduto;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    // MUDANÇA 1: De 'double' para 'Double' (Aceita Null)
    @Column(name = "PRECO")
    private Double preco;

    // MUDANÇA 2: De 'int' para 'Integer' (Aceita Null)
    @Column(name = "QUANTIDADE_ESTOQUE")
    private Integer quantidadeEstoque;

    public Produto() {}

    public Produto(String idProduto, String nome, String descricao, Double preco, Integer quantidadeEstoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getIdProduto() { return idProduto; }
    public void setIdProduto(String idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
}