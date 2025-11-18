package com.mycompany.controller;

import com.mycompany.model.Agendamento;
import com.mycompany.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoApiController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar(@RequestHeader(value = "user-id", required = false) String userId) {

        if (userId == null) {
            return ResponseEntity.ok(List.of());
        }

        return ResponseEntity.ok(service.listarPorPermissao(userId));
    }

    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody Agendamento a) {
        try {
            service.criarAgendamento(
                    a.getCpfCliente(), a.getIdServico(), a.getDataAgendamento(),
                    a.getHoraAgendamento(), a.getFormaPagamento(), a.getValor()
            );
            return ResponseEntity.status(201).body(Map.of("mensagem", "Agendamento criado!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("mensagem", "Erro: " + e.getMessage()));
        }
    }

}