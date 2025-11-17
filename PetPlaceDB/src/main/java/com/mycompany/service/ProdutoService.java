package com.mycompany.service;

import com.mycompany.dao.ProdutoDAO;
import com.mycompany.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProdutoService {

    private final ProdutoDAO dao = new ProdutoDAO();

    // CREATE
    public void cadastrarProduto(String nome, String descricao, double preco, int quantidade) {
        Produto p = new Produto(null, nome, descricao, preco, quantidade);
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
