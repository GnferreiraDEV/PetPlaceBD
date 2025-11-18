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

    // GET: Listar (COM FILTRO DE PERMISSÃO)
    @GetMapping
    public ResponseEntity<List<Agendamento>> listar(@RequestHeader(value = "user-id", required = false) String userId) {
        // Se não vier ID (acesso direto via navegador), retorna lista vazia por segurança
        if (userId == null) {
            return ResponseEntity.ok(List.of());
        }

        // Chama o método inteligente que criamos no Service
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

    // ... (Mantenha os métodos PUT e DELETE se já tiver, ou adicione se precisar) ...
}