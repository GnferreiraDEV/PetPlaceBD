package com.mycompany.service;

import com.mycompany.model.Usuario;
import com.mycompany.model.UsuarioMongo; // <--- Importante
import com.mycompany.repository.UsuarioRepository;
import com.mycompany.repository.UsuarioMongoRepository; // <--- Importante
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository mysqlRepository;

    @Autowired
    private UsuarioMongoRepository mongoRepository; // Injeta o Mongo

    // REGISTRAR (Híbrido: MySQL + Mongo)
    public void registrarUsuario(String nome, String email, String senha, String tipo) {

        // Validações básicas
        if (nome == null || nome.isBlank()) throw new RuntimeException("Nome é obrigatório!");
        if (email == null || email.isBlank()) throw new RuntimeException("Login é obrigatório!");

        // Verifica se já existe no MySQL
        if (mysqlRepository.findByLogin(email) != null) {
            throw new RuntimeException("Login já cadastrado!");
        }

        Usuario u = new Usuario();
        // Gera ID único
        String novoId = "USR_" + UUID.randomUUID().toString().substring(0, 8);
        u.setId_usuario(novoId);
        u.setNome(nome);
        u.setLogin(email);
        u.setSenha(senha); // Salvando sem hash para facilitar seus testes
        u.setId_grupo(tipo);

        // 1. Salva no MySQL (Principal)
        mysqlRepository.save(u);

        // 2. Salva cópia no MongoDB (Requisito)
        try {
            UsuarioMongo copia = new UsuarioMongo(
                    u.getNome(),
                    u.getLogin(),
                    u.getId_grupo(),
                    u.getId_usuario()
            );
            mongoRepository.save(copia);
            System.out.println(">>> Usuário salvo no MySQL e replicado no MongoDB!");
        } catch (Exception e) {
            System.err.println(">>> Erro ao salvar no Mongo: " + e.getMessage());
        }
    }

    // LOGIN (Lê apenas do MySQL)
    public boolean login(String email, String senha) {
        Usuario u = mysqlRepository.findByLogin(email);
        if (u == null) return false;
        return senha.equals(u.getSenha());
    }

    public Usuario buscarPorLogin(String login) {
        return mysqlRepository.findByLogin(login);
    }

    public Usuario buscarPorId(String id) {
        return mysqlRepository.findById(id).orElse(null);
    }

    public List<Usuario> listar() {
        return mysqlRepository.findAll();
    }

    public void atualizar(Usuario u) {
        mysqlRepository.save(u);
    }

    public void deletar(String id) {
        mysqlRepository.deleteById(id);
    }
}