package com.mycompany.controller;

import com.mycompany.model.Cliente;
import com.mycompany.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa todas as anotações web

import java.util.List;

@RestController // 1. Diz ao Spring que esta classe é um Controller de API
@RequestMapping("/api/clientes") // 2. Define o endereço base (ex: /api/clientes)
public class ClienteApiController {

    // 3. O Spring vai injetar o Service que já modernizamos
    private final ClienteService service;

    @Autowired
    public ClienteApiController(ClienteService service) {
        this.service = service;
    }

    // --- ENDPOINTS (Os "quartos" do nosso hotel) ---

    // CREATE (POST /api/clientes)
    @PostMapping
    public void registrar(@RequestBody Cliente cliente) {
        // 4. @RequestBody converte o JSON enviado para um objeto Cliente
        service.registrarCliente(
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco()
        );
    }

    // READ (GET /api/clientes)
    @GetMapping
    public List<Cliente> listar() {
        // 5. O Spring vai converter esta lista de Clientes para JSON automaticamente
        return service.listar();
    }

    // READ (GET /api/clientes/12345678900)
    @GetMapping("/{cpf}")
    public Cliente buscar(@PathVariable String cpf) {
        // 6. @PathVariable pega o 'cpf' que veio na URL
        return service.buscarCliente(cpf);
    }

    // UPDATE (PUT /api/clientes/12345678900)
    @PutMapping("/{cpf}")
    public void atualizar(@PathVariable String cpf, @RequestBody Cliente cliente) {
        service.atualizarCliente(
                cpf, // usa o CPF da URL como garantia
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco()
        );
    }

    // DELETE (DELETE /api/clientes/12345678900)
    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {
        service.deletarCliente(cpf);
    }
}