/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

 import com.mycompany.model.Produto;
import com.mycompany.service.ProdutoService;


/**
 *
 * @author Gustavo
 */
    
   
public class ProdutoController {

    private final ProdutoService service = new ProdutoService();

    public void cadastrar(String nome, String descricao, double preco, int estoque) {
        service.cadastrar(nome, descricao, preco, estoque);
    }

    public Produto buscar(String id) {
        return service.buscar(id);
    }

    public void atualizar(Produto p) {
        service.atualizar(p);
    }

    public void remover(String id) {
        service.remover(id);
    }
}
    

