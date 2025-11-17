package com.mycompany.service;

// 1. Importe o novo Repository e as anotações
import com.mycompany.model.Produto;
import com.mycompany.repository.ProdutoRepository; // <-- Importar
import org.springframework.beans.factory.annotation.Autowired; // <-- Importar
import org.springframework.stereotype.Service; // <-- Importar

import java.util.List;
import java.util.UUID;

// 2. Marque a classe como um "Serviço" do Spring
@Service
public class ProdutoService {

    // 3. NÃO usamos mais o DAO antigo
    // private final ProdutoDAO dao = new ProdutoDAO(); // <-- APAGUE/SUBSTITUA ISSO

    // 4. Declare o Repository que o Spring vai INJETAR
    private final ProdutoRepository repository;

    // 5. Crie um construtor para o Spring fazer a injeção
    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void cadastrarProduto(String nome, String descricao, double preco, int quantidade) {
        String id = "PROD_" + UUID.randomUUID().toString().toUpperCase().substring(0, 8);
        Produto p = new Produto(id, nome, descricao, preco, quantidade);
        repository.save(p); // <-- Use o novo método
    }

    // READ (buscar)
    public Produto buscarProduto(String id) {
        return repository.findById(id).orElse(null);
    }

    // READ (listar todos)
    public List<Produto> listarProdutos() {
        return repository.findAll(); // <-- Use o novo método
    }

    // UPDATE
    public void atualizarProduto(String id, String nome, String descricao, double preco, int quantidade) {
        Produto p = new Produto(id, nome, descricao, preco, quantidade);
        repository.save(p);
    }

    // DELETE
    public void deletarProduto(String id) {
        repository.deleteById(id); // <-- Use o novo método
    }
}