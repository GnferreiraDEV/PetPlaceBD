package com.mycompany.controller;

import com.mycompany.model.ItemCompra;
import com.mycompany.service.CompraService;

public class CompraController {

    private final CompraService service = new CompraService();

    public void registrar(String cpfCliente, ItemCompra... itens) {
        service.registrarCompra(cpfCliente, itens);
    }
}
