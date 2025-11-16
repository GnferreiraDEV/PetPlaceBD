package com.mycompany.service;

import com.mycompany.dao.ProdutoDAO;
import com.mycompany.model.Produto;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO dao = new ProdutoDAO();

    public void cadastrarProduto(String nome, String descricao, double preco, int quantidade) {

        Produto p = new Produto(nome, descricao, preco, quantidade);

        dao.salvar(p);
    }

    public List<Produto> listarProdutos() {
        return dao.listarTodos();
    }
}
