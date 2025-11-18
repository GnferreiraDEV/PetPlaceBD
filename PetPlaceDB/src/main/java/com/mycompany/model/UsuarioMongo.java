package com.mycompany.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class UsuarioMongo {

    @Id
    private String id; // ID interno do Mongo

    private String nome;
    private String email; // login
    private String grupo; // ADMIN ou CLIENTE
    private String idMysql; // Para ligar com o banco SQL

    public UsuarioMongo() {}

    public UsuarioMongo(String nome, String email, String grupo, String idMysql) {
        this.nome = nome;
        this.email = email;
        this.grupo = grupo;
        this.idMysql = idMysql;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public String getIdMysql() { return idMysql; }
    public void setIdMysql(String idMysql) { this.idMysql = idMysql; }
}