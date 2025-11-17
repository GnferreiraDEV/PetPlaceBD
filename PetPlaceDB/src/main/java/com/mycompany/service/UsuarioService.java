package com.mycompany.service;

import com.mycompany.dao.UsuarioDAO;
import com.mycompany.model.Usuario;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

public class UsuarioService {

    private final UsuarioDAO dao = new UsuarioDAO();

    public void registrarUsuario(String nome, String email, String senha, String tipo) {

        // 1. Checar campos obrigatórios
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome é obrigatório!");
            return;
        }
        if (email == null || email.isBlank()) {
            System.out.println("Login é obrigatório!");
            return;
        }

        // 2. Checar se o login já existe
        if (dao.buscarPorLogin(email) != null) {
            System.out.println("Login já cadastrado!");
            return;
        }
        
        Usuario u = new Usuario();
        u.setId_usuario(UUID.randomUUID().toString());
        u.setNome(nome);
        u.setLogin(email);
        u.setSenha(gerarHash(senha));
        u.setId_grupo(tipo);

        dao.salvar(u);
    }

    public boolean login(String email, String senha) {
        Usuario u = dao.buscarPorLogin(email);

        if (u == null) return false;

        String senhaHash = gerarHash(senha);

        return senhaHash.equals(u.getSenha());
    }

    // --------------------------
    // CRUD COMPLETO
    // --------------------------

    public Usuario buscarPorId(String id) {
        return dao.buscarPorId(id);
    }

    public List<Usuario> listar() {
        return dao.listarTodos();
    }

    public void atualizar(Usuario u) {

        // Se a senha for atualizada, precisa rehash
        if (!u.getSenha().startsWith("00")) { 
            // <-- Se quiser detectar hash, ajusta isso
            u.setSenha(gerarHash(u.getSenha()));
        }

        dao.atualizar(u);
    }

    public void deletar(String id) {
        dao.deletar(id);
    }

    // --------------------------
    // Hash
    // --------------------------
    private String gerarHash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }
}
