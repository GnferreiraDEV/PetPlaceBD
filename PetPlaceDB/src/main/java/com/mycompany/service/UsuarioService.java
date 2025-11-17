package com.mycompany.service;

import com.mycompany.model.Usuario;
import com.mycompany.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void registrarUsuario(String nome, String email, String senha, String tipo) {
        if (nome == null || nome.isBlank()) throw new RuntimeException("Nome é obrigatório!");
        if (email == null || email.isBlank()) throw new RuntimeException("Login é obrigatório!");
        if (repository.findByLogin(email) != null) throw new RuntimeException("Login já cadastrado!");

        Usuario u = new Usuario();
        u.setId_usuario("USR_" + UUID.randomUUID().toString().substring(0, 8));
        u.setNome(nome);
        u.setLogin(email);

        // MUDANÇA 1: Salva a senha direto (Texto Puro)
        u.setSenha(senha);

        u.setId_grupo(tipo);

        repository.save(u);
    }

    public boolean login(String email, String senha) {
        Usuario u = repository.findByLogin(email);

        if (u == null) return false;

        // MUDANÇA 2: Compara direto a senha digitada com a do banco
        return senha.equals(u.getSenha());
    }

    public Usuario buscarPorLogin(String login) {
        return repository.findByLogin(login);
    }

    public Usuario buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public void atualizar(Usuario u) {
        // MUDANÇA 3: Não faz hash na atualização
        repository.save(u);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}