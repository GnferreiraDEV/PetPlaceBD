package com.mycompany.controller;

import com.mycompany.model.Agendamento;
import com.mycompany.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // Indica que é uma API REST
@RequestMapping("/api/agendamentos") // URL base: localhost:8080/api/agendamentos
@CrossOrigin(origins = "*") // Libera o acesso para seu Front-end
public class AgendamentoApiController {

    private final AgendamentoService service;

    // Injeção de Dependência correta (o Spring cria o service)
    @Autowired
    public AgendamentoApiController(AgendamentoService service) {
        this.service = service;
    }

    // ==========================
    // READ (Listar e Buscar)
    // ==========================

    // GET: http://localhost:8080/api/agendamentos
    @GetMapping
    public ResponseEntity<List<Agendamento>> listar() {
        List<Agendamento> lista = service.listarTodos();
        // O Spring transforma essa lista em JSON automaticamente
        return ResponseEntity.ok(lista);
    }

    // GET: http://localhost:8080/api/agendamentos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable String id) {
        Agendamento agendamento = service.buscarPorId(id);

        if (agendamento != null) {
            return ResponseEntity.ok(agendamento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Agendamento não encontrado"));
        }
    }

    // ==========================
    // CREATE (Agendar)
    // ==========================

    // POST: http://localhost:8080/api/agendamentos
    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody Agendamento a) {
        try {
            // Extraindo os dados do JSON (objeto 'a') para passar ao seu serviço
            service.criarAgendamento(
                    a.getCpfCliente(),
                    a.getIdServico(),
                    a.getDataAgendamento(),
                    a.getHoraAgendamento(),
                    a.getFormaPagamento(),
                    a.getValor()
            );

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("mensagem", "Agendamento criado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensagem", "Erro ao agendar: " + e.getMessage()));
        }
    }

    // ==========================
    // UPDATE (Atualizar)
    // ==========================

    // PUT: http://localhost:8080/api/agendamentos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody Agendamento a) {
        try {
            // Garante que o ID do objeto é o mesmo da URL
            a.setIdAgendamento(id);

            service.atualizarAgendamento(a);

            return ResponseEntity.ok()
                    .body(Map.of("mensagem", "Agendamento atualizado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensagem", "Erro ao atualizar: " + e.getMessage()));
        }
    }

    // ==========================
    // DELETE (Deletar)
    // ==========================

    // DELETE: http://localhost:8080/api/agendamentos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        try {
            service.deletarAgendamento(id);
            return ResponseEntity.ok(Map.of("mensagem", "Agendamento removido."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("mensagem", "Erro ao deletar: " + e.getMessage()));
        }
    }
}