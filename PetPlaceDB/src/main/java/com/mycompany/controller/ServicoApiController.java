package com.mycompany.controller;

import com.mycompany.model.Servico;
import com.mycompany.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoApiController {

    private final ServicoService service;

    @Autowired
    public ServicoApiController(ServicoService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrar(@RequestBody Servico servico) {

        service.cadastrarServico(
                servico.getDescricao(),
                servico.getPreco(),
                servico.isBanho(),
                servico.isTosa()
        );
    }

    @GetMapping
    public List<Servico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Servico buscar(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Servico servico) {
        service.atualizarServico(
                id,
                servico.getDescricao(),
                servico.getPreco(),
                servico.isBanho(),
                servico.isTosa()
        );
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletarServico(id);
    }
}