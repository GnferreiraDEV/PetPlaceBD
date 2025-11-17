package com.mycompany.controller;

import com.mycompany.model.Produto;
import com.mycompany.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*") // Libera o acesso para o seu site (Front-end)
public class ProdutoApiController {

    private final ProdutoService service;

    @Autowired
    public ProdutoApiController(ProdutoService service) {
        this.service = service;
    }

    // CREATE (POST)
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
        try {
            // Passamos o objeto inteiro. O Service vai gerar o ID se faltar.
            Produto salvo = service.salvar(produto);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("mensagem", "Erro ao salvar: " + e.getMessage()));
        }
    }

    // READ (GET Lista)
    @GetMapping
    public List<Produto> listar() {
        // O nome do método no Service agora é 'listarTodos'
        return service.listarTodos();
    }

    // READ (GET Único)
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable String id) {
        Produto p = service.buscarPorId(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody Produto produto) {
        // Garante que o ID do objeto seja o mesmo da URL para não criar duplicado
        produto.setIdProduto(id);

        Produto salvo = service.salvar(produto);
        return ResponseEntity.ok(salvo);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.ok(Map.of("mensagem", "Produto removido com sucesso."));
    }
}