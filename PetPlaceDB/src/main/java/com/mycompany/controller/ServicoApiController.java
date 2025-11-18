package com.mycompany.controller;

import com.mycompany.model.Servico;
import com.mycompany.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa todas as anotações web

import java.util.List;

@RestController // 1. Diz ao Spring que é um Controller de API (retorna JSON)
@RequestMapping("/api/servicos") // 2. Define o endereço base (ex: /api/servicos)
public class ServicoApiController {

    // 3. Injeta o ServicoService que acabamos de modernizar
    private final ServicoService service;

    @Autowired
    public ServicoApiController(ServicoService service) {
        this.service = service;
    }

    // --- ENDPOINTS ---

    // CREATE (POST /api/servicos)
    @PostMapping
    public void cadastrar(@RequestBody Servico servico) {
        // 4. @RequestBody converte o JSON enviado para um objeto Servico
        //    (O ID será gerado dentro do serviço)
        service.cadastrarServico(
                servico.getDescricao(),
                servico.getPreco(),
                servico.isBanho(),
                servico.isTosa()
        );
    }

    // READ (GET /api/servicos)
    @GetMapping
    public List<Servico> listar() {
        // 5. O Spring converte esta lista para JSON automaticamente
        return service.listar();
    }

    // READ (GET /api/servicos/SERV_12345)
    @GetMapping("/{id}")
    public Servico buscar(@PathVariable String id) {
        // 6. @PathVariable pega o 'id' que veio na URL
        return service.buscarPorId(id);
    }

    // UPDATE (PUT /api/servicos/SERV_12345)
    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Servico servico) {
        service.atualizarServico(
                id, // Usa o ID da URL como garantia
                servico.getDescricao(),
                servico.getPreco(),
                servico.isBanho(),
                servico.isTosa()
        );
    }

    // DELETE (DELETE /api/servicos/SERV_12345)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletarServico(id);
    }
}