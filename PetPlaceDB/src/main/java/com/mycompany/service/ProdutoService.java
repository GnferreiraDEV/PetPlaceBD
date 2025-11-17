package com.mycompany.service;

import com.mycompany.dao.ProdutoDAO;
import com.mycompany.model.Produto;

import java.util.List;
import java.util.UUID;

public class ProdutoService {

    private final ProdutoDAO dao = new ProdutoDAO();

    // CREATE
    public void cadastrarProduto(String nome, String descricao, double preco, int quantidade) {
        String id = "PROD_" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);

        Produto p = new Produto(id, nome, descricao, preco, quantidade);
        dao.salvar(p);
    }

    // READ (buscar)
    public Produto buscarProduto(String id) {
        return dao.buscarPorId(id);
    }

    // READ (listar todos)
    public List<Produto> listarProdutos() {
        return dao.listarTodos();
    }

    // UPDATE
    public void atualizarProduto(String id, String nome, String descricao, double preco, int quantidade) {
        Produto p = new Produto(id, nome, descricao, preco, quantidade);
        dao.atualizar(p);
    }

    // DELETE
    public void deletarProduto(String id) {
        dao.deletar(id);
    }
}
