package com.mycompany.petplacedb;

import com.mycompany.controller.CompraController;
import com.mycompany.model.ItemCompra;

public class App {

    public static void main(String[] args) {

        CompraController cc = new CompraController();

        cc.registrar(
                "12345678901",  // CPF que existe no MySQL
                new ItemCompra("PROD_ABC123", 2),
                new ItemCompra("PROD_XYZ999", 1)
        );

        System.out.println("Compra criada com sucesso!");
    }
}
