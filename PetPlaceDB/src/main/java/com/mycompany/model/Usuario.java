package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios") // O nome da tabela no seu script SQL é minúsculo
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private String id_usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "id_grupo") // Mapeando direto como coluna para facilitar seu Controller atual
    private String id_grupo;

    public Usuario() {}

    // Mantenha seus construtores e Getters/Setters aqui...
    public Usuario(String id_usuario, String nome, String login, String senha, String id_grupo) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.id_grupo = id_grupo;
    }

    public String getId_usuario() { return id_usuario; }
    public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getId_grupo() { return id_grupo; }
    public void setId_grupo(String id_grupo) { this.id_grupo = id_grupo; }
}