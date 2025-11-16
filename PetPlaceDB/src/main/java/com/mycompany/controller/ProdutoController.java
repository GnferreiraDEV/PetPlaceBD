package com.mycompany.controller;

import com.mycompany.service.ProdutoService;
import com.mycompany.model.Produto;

import java.util.List;

public class ProdutoController {

    private ProdutoService service = new ProdutoService();

    public void cadastrar(String nome, String descricao, double preco, int quantidade) {
        service.cadastrarProduto(nome, descricao, preco, quantidade);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listar() {
        List<Produto> produtos = service.listarProdutos();

        for (Produto p : produtos) {
            System.out.println(
                p.getIdProduto() + " | " +
                p.getNome() + " | Estoque: " + p.getQuantidadeEstoque()
            );
        }
    }
}
