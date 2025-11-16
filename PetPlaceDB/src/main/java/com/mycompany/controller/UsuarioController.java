/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.service.UsuarioService;

/**
 *
 * @author Gustavo
 */


public class UsuarioController {

    private final UsuarioService service = new UsuarioService();

    public void registrar(String nome, String email, String senha, String tipo) {
        service.registrarUsuario(nome, email, senha, tipo);
    }

    public boolean login(String email, String senha) {
        return service.login(email, senha);
    }
}
