package com.mycompany.petplacedb;

import com.mycompany.controller.ProdutoController;

public class App {
    public static void main(String[] args) {

        ProdutoController pc = new ProdutoController();

        // CADASTRAR PRODUTOS
//        pc.cadastrar("Ração Golden 10kg","A melhor do nordeste", 139.90, 10);
//        pc.cadastrar("Brinquedo Bola","test", 19.90, 30);

//        // LISTAR
//        System.out.println("\n--- LISTA DE PRODUTOS ---");
//        pc.listar();
//
//        // ATUALIZAR
//        System.out.println("\n--- ATUALIZANDO PRODUTO 1 ---");
//        pc.atualizar("6ab0ecb9-e20c-4a76-a863-a129a5ac0e53", "Ração Golden Special 10kg","A melhor da bahia", 149.90, 15);
//
//        pc.listar();
//
//        // EXCLUIR
        System.out.println("\n--- EXCLUINDO PRODUTO 2 ---");
        pc.deletar("e4fc6f25-d011-4e10-9772-ca08d27f18a0");

        pc.listar();
    }
}
