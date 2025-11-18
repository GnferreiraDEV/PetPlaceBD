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
@CrossOrigin(origins = "*")
public class ProdutoApiController {

    private final ProdutoService service;

    @Autowired
    public ProdutoApiController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
        try {

            Produto salvo = service.salvar(produto);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("mensagem", "Erro ao salvar: " + e.getMessage()));
        }
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable String id) {
        Produto p = service.buscarPorId(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody Produto produto) {

        produto.setIdProduto(id);

        Produto salvo = service.salvar(produto);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.ok(Map.of("mensagem", "Produto removido com sucesso."));
    }
}