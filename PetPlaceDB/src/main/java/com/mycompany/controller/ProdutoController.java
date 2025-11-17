package com.mycompany.controller;

import com.mycompany.service.ProdutoService;
import com.mycompany.model.Produto;

import java.util.List;

public class ProdutoController {

    private final ProdutoService service = new ProdutoService();

    // CREATE
    public void cadastrar(String nome, String descricao, double preco, int quantidade) {
        service.cadastrarProduto(nome, descricao, preco, quantidade);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // READ (um produto)
    public Produto buscar(String id) {
        return service.buscarProduto(id);
    }

    // READ (listar)
    public void listar() {
        List<Produto> produtos = service.listarProdutos();

        for (Produto p : produtos) {
            System.out.println(
                p.getIdProduto() + " | " +
                p.getNome() + " | R$" + p.getPreco() +
                " | Estoque: " + p.getQuantidadeEstoque()
            );
        }
    }

    // UPDATE
    public void atualizar(String id, String nome, String descricao, double preco, int quantidade) {
        service.atualizarProduto(id, nome, descricao, preco, quantidade);
        System.out.println("Produto atualizado com sucesso!");
    }

    // DELETE
    public void deletar(String id) {
        service.deletarProduto(id);
        System.out.println("Produto deletado com sucesso!");
    }
}
