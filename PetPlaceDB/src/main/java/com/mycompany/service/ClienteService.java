package com.mycompany.service;

// 1. Importe o novo Repository e as anotações do Spring
import com.mycompany.repository.ClienteRepository;
import com.mycompany.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 2. Diga ao Spring que esta é uma classe de "Serviço"
@Service
public class ClienteService {

    // 3. NÃO VAMOS MAIS FAZER new ClienteDAO()
    // private final ClienteDAO dao = new ClienteDAO(); // <-- LINHA ANTIGA DELETADA

    // 4. Declare o Repository que o Spring vai INJETAR
    private final ClienteRepository repository;

    // 5. Crie um construtor para o Spring "injetar" o repository
    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void registrarCliente(String cpf, String nome, String telefone, String email, String endereco) {
        Cliente c = new Cliente(cpf, nome, telefone, email, endereco);
        // 6. Use o método do Spring (substitui o 'salvar')
        repository.save(c);
    }

    // READ
    public Cliente buscarCliente(String cpf) {
        // 7. Use o método do Spring (substitui o 'buscarPorCpf')
        // .orElse(null) é para manter o comportamento antigo (retornar null se não achar)
        return repository.findById(cpf).orElse(null);
    }

    public List<Cliente> listar() {
        // 8. Use o método do Spring (substitui o 'listarTodos')
        return repository.findAll();
    }

    // UPDATE
    public void atualizarCliente(String cpf, String nome, String telefone, String email, String endereco) {
        Cliente c = new Cliente(cpf, nome, telefone, email, endereco);
        // 9. O 'save' do Spring é inteligente!
        // Se o Cliente (pelo @Id 'cpf') já existe, ele ATUALIZA. Se não, ele CRIA.
        repository.save(c);
    }

    // DELETE
    public void deletarCliente(String cpf) {
        // 10. Use o método do Spring (substitui o 'deletar')
        repository.deleteById(cpf);
    }
}