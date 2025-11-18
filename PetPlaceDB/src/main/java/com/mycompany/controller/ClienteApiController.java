package com.mycompany.controller;

import com.mycompany.model.Cliente;
import com.mycompany.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteApiController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cliente c) {

        System.out.println("--- TENTANDO CADASTRAR CLIENTE ---");
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Nome: " + c.getNome());
        System.out.println("Endereço: " + c.getEndereco());

        try {
            Cliente novo = service.salvar(c);
            System.out.println(">>> SUCESSO! Cliente salvo.");
            return ResponseEntity.ok(novo);
        } catch (Exception e) {

            System.err.println(">>> ERRO AO SALVAR CLIENTE:");
            e.printStackTrace();

            return ResponseEntity.badRequest().body(Map.of("erro", "Erro no servidor: " + e.getMessage()));
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deletar(@PathVariable String cpf) {
        try {
            service.deletar(cpf);
            return ResponseEntity.ok(Map.of("mensagem", "Cliente removido"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        }
    }
}