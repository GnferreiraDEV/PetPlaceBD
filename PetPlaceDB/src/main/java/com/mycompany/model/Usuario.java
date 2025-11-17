/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Gustavo
 */
public class Usuario {
    private String id_usuario;
    private String nome;
    private String login;
    private String senha;
    private String id_grupo;

    public Usuario() {}

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
