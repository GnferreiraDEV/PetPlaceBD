/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petplacedb;

import com.mycompany.controller.UsuarioController;

public class App {

    public static void main(String[] args) {

        UsuarioController uc = new UsuarioController();

    // CADASTRO
    uc.registrar("Gustavo", "gustavo@email.com", "admin123", "admin");
    System.out.println("Usuário cadastrado!");

    // LOGIN
    boolean ok = uc.login("gustavo@email.com", "admin123");
    System.out.println("Login: " + ok);

    }
}
