package com.mycompany.service;

import com.mycompany.dao.ClienteDAO;
import com.mycompany.model.Cliente;
import java.util.List;

public class ClienteService {

    private final ClienteDAO dao = new ClienteDAO();

    // CREATE
    public void registrarCliente(String cpf, String nome, String telefone, String email, String endereco) {
        Cliente c = new Cliente(cpf, nome, telefone, email, endereco);
        dao.salvar(c);
    }

    // READ
    public Cliente buscarCliente(String cpf) {
        return dao.buscarPorCpf(cpf);
    }

    public List<Cliente> listar() {
        return dao.listarTodos();
    }

    // UPDATE
    public void atualizarCliente(String cpf, String nome, String telefone, String email, String endereco) {
        Cliente c = new Cliente(cpf, nome, telefone, email, endereco);
        dao.atualizar(c);
    }

    // DELETE
    public void deletarCliente(String cpf) {
        dao.deletar(cpf);
    }
}
