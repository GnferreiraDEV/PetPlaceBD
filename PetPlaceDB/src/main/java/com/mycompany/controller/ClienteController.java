package com.mycompany.controller;

import com.mycompany.service.ClienteService;
import com.mycompany.model.Cliente;
import java.util.List;

public class ClienteController {

    private ClienteService service = new ClienteService();

    public void registrar(String cpf, String nome, String telefone, String email, String endereco) {
        service.registrarCliente(cpf, nome, telefone, email, endereco);
    }

    public Cliente buscar(String cpf) {
        return service.buscarCliente(cpf);
    }

    public List<Cliente> listar() {
        return service.listar();
    }
}
