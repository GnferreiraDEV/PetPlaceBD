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

    public List<Agendamento> listarPorPermissao(String userId) {
        Usuario u = usuarioRepository.findById(userId).orElse(null);

        if (u == null) return Collections.emptyList();


        if ("ADMIN".equalsIgnoreCase(u.getId_grupo())) {
            return repository.findAll();
        }


        Cliente c = clienteRepository.findByEmail(u.getLogin());

        if (c != null) {

            return repository.findByCpfCliente(c.getCpf());
        }

        return Collections.emptyList();
    }


    public void criarAgendamento(String cpf, String idServico, String data, String hora,
                                 String formaPagamento, double valor) {

        Agendamento ag = new Agendamento();
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

    public Agendamento buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }


    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }


    public void atualizarAgendamento(Agendamento ag) {

        repository.save(ag);
    }

    public void deletarAgendamento(String id) {
        repository.deleteById(id);
    }
}