package com.mycompany.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document diz que isso vai ser salvo numa coleção do Mongo chamada "produtos"
@Document(collection = "produtos")
public class ProdutoMongo {

    @Id // Este é o ID interno do Mongo (aquele código doido cheio de letras)
    private String id;

    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;

    // Importante: Vamos guardar o ID do MySQL aqui para saber de quem é essa cópia
    private String idMysql;

    public ProdutoMongo() {}

    // Construtor prático para copiar dados
    public ProdutoMongo(String nome, String descricao, Double preco, Integer quantidadeEstoque, String idMysql) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.idMysql = idMysql;
    }

    // --- Getters e Setters ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public String getIdMysql() { return idMysql; }
    public void setIdMysql(String idMysql) { this.idMysql = idMysql; }
}