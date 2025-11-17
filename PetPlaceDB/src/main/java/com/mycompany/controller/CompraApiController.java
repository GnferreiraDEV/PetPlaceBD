package com.mycompany.controller;

import com.mycompany.model.Compra;
import com.mycompany.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class CompraApiController {

    @Autowired
    private CompraService service;

    @PostMapping
    public ResponseEntity<?> novaCompra(@RequestBody Compra compra) {
        try {
            service.realizarCompra(compra);
            return ResponseEntity.ok(Map.of("mensagem", "Venda realizada com sucesso!"));
        } catch (Exception e) {
            e.printStackTrace(); // Mostra o erro no console do Java
            return ResponseEntity.badRequest().body(Map.of("mensagem", "Erro ao processar venda: " + e.getMessage()));
        }
    }
}