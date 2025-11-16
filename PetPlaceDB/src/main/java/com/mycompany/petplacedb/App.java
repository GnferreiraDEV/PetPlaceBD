/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petplacedb;

import com.mycompany.controller.ProdutoController;

public class App {
    public static void main(String[] args) {

        ProdutoController pc = new ProdutoController();

        // CADASTRAR PRODUTO
        pc.cadastrar("Ração Golden", "Ração premium 15kg", 129.90, 40);
        System.out.println("Produto inserido!");

    }
}

