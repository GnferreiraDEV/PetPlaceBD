package com.mycompany.controller;

import com.mycompany.service.ClienteService;
import com.mycompany.model.Cliente;
import java.util.List;

public class ClienteController {

    private final ClienteService service = new ClienteService();

    // CREATE
    public void registrar(String cpf, String nome, String telefone, String email, String endereco) {
        service.registrarCliente(cpf, nome, telefone, email, endereco);
    }

    // READ (buscar por CPF)
    public Cliente buscar(String cpf) {
        return service.buscarCliente(cpf);
    }

    // READ (listar todos)
    public List<Cliente> listar() {
        return service.listar();
    }

    // UPDATE
    public void atualizar(String cpf, String nome, String telefone, String email, String endereco) {
        Cliente c = new Cliente(cpf, nome, telefone, email, endereco);
        service.atualizarCliente(c.getCpf(), c.getNome(), c.getTelefone(), c.getEmail(), c.getEndereco());
    }

    // DELETE
    public void deletar(String cpf) {
        service.deletarCliente(cpf);
    }

    // LISTAR formatado (igual o ServicoController)
    public void listarFormatado() {
        List<Cliente> lista = service.listar();

        for (Cliente c : lista) {
            System.out.println(
                c.getCpf() + " | " +
                c.getNome() + " | " +
                c.getTelefone() + " | " +
                c.getEmail() + " | " +
                c.getEndereco()
            );
        }
    }
}
