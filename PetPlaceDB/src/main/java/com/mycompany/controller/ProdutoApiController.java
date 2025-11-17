package com.mycompany.controller;

import com.mycompany.model.Produto;
import com.mycompany.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa todas as anotações web

import java.util.List;

@RestController // 1. Diz ao Spring que é um Controller de API (retorna JSON)
@RequestMapping("/api/produtos") // 2. Define o endereço base (ex: /api/produtos)
public class ProdutoApiController {

    // 3. Injeta o ProdutoService que acabamos de modernizar
    private final ProdutoService service;

    @Autowired
    public ProdutoApiController(ProdutoService service) {
        this.service = service;
    }

    // --- ENDPOINTS ---

    // CREATE (POST /api/produtos)
    @PostMapping
    public void cadastrar(@RequestBody Produto produto) {
        // 4. @RequestBody converte o JSON enviado para um objeto Produto
        //    (Note que o ID será gerado dentro do serviço)
        service.cadastrarProduto(
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEstoque()
        );
    }

    // READ (GET /api/produtos)
    @GetMapping
    public List<Produto> listar() {
        // 5. O Spring converte esta lista para JSON automaticamente
        return service.listarProdutos();
    }

    // READ (GET /api/produtos/PROD_12345)
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable String id) {
        // 6. @PathVariable pega o 'id' que veio na URL
        return service.buscarProduto(id);
    }

    // UPDATE (PUT /api/produtos/PROD_12345)
    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Produto produto) {
        service.atualizarProduto(
                id, // Usa o ID da URL como garantia
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEstoque()
        );
    }

    // DELETE (DELETE /api/produtos/PROD_12345)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletarProduto(id);
    }
}