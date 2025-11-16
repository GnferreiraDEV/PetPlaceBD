package com.mycompany.petplacedb;

import com.mycompany.controller.ServicoController;


public class App {

    public static void main(String[] args) {

       
        
        ServicoController sc = new ServicoController();

    // CADASTRAR SERVIÇOS
    sc.cadastrar("Banho Completo", 59.90, true, false);
    sc.cadastrar("Tosa Especial", 79.90, false, true);

    // LISTAR
    System.out.println("\n--- LISTA DE SERVIÇOS ---");
    sc.listar();

    }
}
