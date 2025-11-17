package com.mycompany.controller;

import com.mycompany.model.Compra;
import com.mycompany.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class CompraApiController {

    @Autowired
    private CompraService service;

    @GetMapping
    public ResponseEntity<List<Compra>> listar(@RequestHeader(value = "user-id", required = false) String userId) {
        if (userId == null) return ResponseEntity.ok(List.of());
        return ResponseEntity.ok(service.listarPorPermissao(userId));
    }

    @PostMapping
    public ResponseEntity<?> novaCompra(@RequestBody Compra compra) {
        try {
            service.realizarCompra(compra);
            return ResponseEntity.ok(Map.of("mensagem", "Venda realizada com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("mensagem", "Erro: " + e.getMessage()));
        }
    }
}