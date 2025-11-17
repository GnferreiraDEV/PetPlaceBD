package com.mycompany.service;

import com.mycompany.model.Cliente;
import com.mycompany.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // CREATE e UPDATE
    // O Controller manda o objeto 'Cliente' inteiro, não variáveis soltas
    public Cliente salvar(Cliente c) {
        return repository.save(c);
    }

    // READ (Lista)
    // O Controller chama 'listarTodos', então o nome tem que ser igual
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    // READ (Busca Única)
    public Cliente buscarPorCpf(String cpf) {
        return repository.findById(cpf).orElse(null);
    }

    // DELETE
    public void deletar(String cpf) {
        repository.deleteById(cpf);
    }
}