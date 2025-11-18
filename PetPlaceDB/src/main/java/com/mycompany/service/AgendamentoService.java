package com.mycompany.service;

import com.mycompany.model.Agendamento;
import com.mycompany.model.Cliente;
import com.mycompany.model.Usuario;
import com.mycompany.repository.AgendamentoRepository;
import com.mycompany.repository.ClienteRepository;
import com.mycompany.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // =====================================================================
    // LÓGICA INTELIGENTE: Filtrar por permissão (Admin vê tudo, Cliente vê o dele)
    // =====================================================================
    public List<Agendamento> listarPorPermissao(String userId) {
        // 1. Busca quem é o usuário logado
        Usuario u = usuarioRepository.findById(userId).orElse(null);

        if (u == null) return Collections.emptyList(); // Segurança

        // 2. Se for ADMIN, retorna TUDO
        if ("ADMIN".equalsIgnoreCase(u.getId_grupo())) {
            return repository.findAll();
        }

        // 3. Se for CLIENTE, descobre o CPF através do email
        // (O Login do usuário é o email, que deve ser igual ao email na tabela Cliente)
        Cliente c = clienteRepository.findByEmail(u.getLogin());

        if (c != null) {
            // Retorna apenas os agendamentos desse CPF
            return repository.findByCpfCliente(c.getCpf());
        }

        return Collections.emptyList(); // Não achou cliente vinculado
    }

    // =====================================================================
    // MÉTODOS PADRÃO (CRUD)
    // =====================================================================

    // CREATE
    public void criarAgendamento(String cpf, String idServico, String data, String hora,
                                 String formaPagamento, double valor) {

        Agendamento ag = new Agendamento();
        // Gera ID único com prefixo para ficar organizado
        ag.setIdAgendamento("AG_" + UUID.randomUUID().toString().substring(0, 8));
        ag.setCpfCliente(cpf);
        ag.setIdServico(idServico);
        ag.setDataAgendamento(data);
        ag.setHoraAgendamento(hora);
        ag.setFormaPagamento(formaPagamento);
        ag.setValor(valor);
        ag.setStatus("AGENDADO");

        repository.save(ag);
    }

    // READ (Busca única)
    public Agendamento buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }

    // READ (Listar todos - Uso interno ou Admin direto)
    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    // UPDATE
    public void atualizarAgendamento(Agendamento ag) {
        // O save do repository serve para atualizar também se o ID existir
        repository.save(ag);
    }

    // DELETE
    public void deletarAgendamento(String id) {
        repository.deleteById(id);
    }
}