package com.mycompany.service;

import com.mycompany.dao.CompraDAO;
import com.mycompany.dao.ProdutoDAO;
import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra;
import com.mycompany.model.Produto;

public class CompraService {

    private final CompraDAO dao = new CompraDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO(); // pra pegar preço do produto

    public void registrarCompra(String cpfCliente, ItemCompra... itens) {

        Compra compra = new Compra();
        compra.setCpfCliente(cpfCliente);

        double total = 0;

        for (ItemCompra it : itens) {
            compra.addItem(it);

            // Buscar preço atualizado do produto no banco
            Produto produto = produtoDAO.buscarPorId(it.getIdProduto());
            if (produto != null) {
                total += produto.getPreco() * it.getQuantidade();
            } else {
                throw new RuntimeException("Produto não encontrado: " + it.getIdProduto());
            }
        }

        compra.setValorTotal(total);

        // Chama o DAO para salvar a compra e os itens
        dao.salvar(compra);

        System.out.println("Compra registrada com sucesso! ID: " + compra.getIdCompra() + ", Total: R$" + total);
    }
}
