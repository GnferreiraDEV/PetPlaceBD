package com.mycompany.service;

import com.mycompany.dao.CompraDAO;
import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra;
import java.util.UUID;

public class CompraService {

    private final CompraDAO dao = new CompraDAO();

    public void registrarCompra(String cpfCliente, ItemCompra... itens) {

        Compra compra = new Compra();
        compra.setIdCompra("COMP_" + UUID.randomUUID().toString().replace("-", ""));
        compra.setCpfCliente(cpfCliente);

        double total = 0;

        for (ItemCompra it : itens) {
            compra.addItem(it);
            // Não pega preco aqui – MySQL não exige
            total += 0; 
        }

        compra.setValorTotal(total);

        dao.salvar(compra);

        System.out.println("Compra registrada com sucesso! ID: " + compra.getIdCompra());
    }
}
