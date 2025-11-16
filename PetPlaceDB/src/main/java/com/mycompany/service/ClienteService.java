package com.mycompany.service;

import com.mycompany.dao.ClienteDAO;
import com.mycompany.model.Cliente;
import java.util.List;

public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();

    public void registrarCliente(String cpf, String nome, String telefone, String email, String endereco) {
        Cliente c = new Cliente();
        c.setCpf(cpf);
        c.setNome(nome);
        c.setTelefone(telefone);
        c.setEmail(email);
        c.setEndereco(endereco);

        dao.salvar(c);
    }

    public Cliente buscarCliente(String cpf) {
        return dao.buscarPorCPF(cpf);
    }

    public List<Cliente> listar() {
        return dao.listarTodos();
    }
}
