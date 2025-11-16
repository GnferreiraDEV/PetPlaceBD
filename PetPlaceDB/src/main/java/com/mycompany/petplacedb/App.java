/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petplacedb;

import com.mycompany.controller.AgendamentoController;

public class App {

    public static void main(String[] args) {

        AgendamentoController controller = new AgendamentoController();

        controller.agendar(
                "12345678901",
                "SERV001",
                "2025-11-20",
                "10:30",
                "PIX",
                79.90
        );

        System.out.println("Agendamento criado com sucesso!");
    }
}
