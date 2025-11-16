/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.ProdutoDAO;
import com.mycompany.model.Produto;
import java.util.UUID;

/**
 *
 * @author Gustavo
 */

public class ProdutoService {

    private final ProdutoDAO dao = new ProdutoDAO();

    public void cadastrar(String nome, String descricao, double preco, int estoque) {

        Produto p = new Produto();
        p.setId(UUID.randomUUID().toString());
        p.setNome(nome);
        p.setDescricao(descricao);
        p.setPreco(preco);
        p.setEstoque(estoque);

        dao.salvar(p);
    }

    public Produto buscar(String id) {
        return dao.buscarPorId(id);
    }

    public void atualizar(Produto p) {
        dao.atualizar(p);
    }

    public void remover(String id) {
        dao.remover(id);
    }
}


