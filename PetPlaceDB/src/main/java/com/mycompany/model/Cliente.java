package com.mycompany.model;

// 1. Importe a anotação @Column
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "CPF") // <-- Mapeia o campo 'cpf' para a coluna 'CPF'
    private String cpf;

    @Column(name = "NOME") // <-- Mapeia o campo 'nome' para a coluna 'NOME'
    private String nome;

    @Column(name = "TELEFONE") // <-- Mapeia o campo 'telefone' para a coluna 'TELEFONE'
    private String telefone;

    @Column(name = "EMAIL") // <-- Mapeia o campo 'email' para a coluna 'EMAIL'
    private String email;

    @Column(name = "ENDERECO") // <-- Mapeia o campo 'endereco' para a coluna 'ENDERECO'
    private String endereco;

    // --- Construtores ---
    public Cliente() {}

    public Cliente(String cpf, String nome, String telefone, String email, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // --- Getters e Setters ---
    // (Não mudam)

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