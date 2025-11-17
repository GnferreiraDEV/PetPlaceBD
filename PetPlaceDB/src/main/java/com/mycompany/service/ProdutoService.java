package com.mycompany.service;

import com.mycompany.model.Produto;
import com.mycompany.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID; // <--- Importante para gerar o ID

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }

    public Produto salvar(Produto p) {
        // VERIFICAÇÃO: Se o produto não tem ID, cria um novo
        if (p.getIdProduto() == null || p.getIdProduto().isEmpty()) {
            // Gera algo como: PROD_a1b2c3d4
            String idGerado = "PROD_" + UUID.randomUUID().toString().substring(0, 8);
            p.setIdProduto(idGerado);
        }

        return repository.save(p);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}