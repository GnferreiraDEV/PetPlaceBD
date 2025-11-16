/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petplacedb;

import com.mycompany.controller.ProdutoController;

public class App {
    public static void main(String[] args) {

        ProdutoController pc = new ProdutoController();

pc.cadastrar("Ração Premium", "Ração para cães adultos", 89.90, 50);

pc.listar();


    }
}

