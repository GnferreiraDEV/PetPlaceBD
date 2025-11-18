package com.mycompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @Column(name = "CPF")
    private String cpf;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ENDERECO")
    private String endereco;

    public Cliente() {}

    public Cliente(String cpf, String nome, String telefone, String email, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}