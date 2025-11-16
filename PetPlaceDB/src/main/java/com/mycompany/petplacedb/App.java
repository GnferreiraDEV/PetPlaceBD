package com.mycompany.petplacedb;

import com.mycompany.controller.ClienteController;

public class App {

    public static void main(String[] args) {

        // ==========================
// TESTE DE CLIENTE
// ==========================
ClienteController cli = new ClienteController();

System.out.println("=== CADASTRANDO CLIENTE ===");
cli.registrar("12345678901", "Maria Silva", "61999998888", "maria@gmail.com", "Rua das Flores 100");

System.out.println("Cliente cadastrado!");

    }
}
