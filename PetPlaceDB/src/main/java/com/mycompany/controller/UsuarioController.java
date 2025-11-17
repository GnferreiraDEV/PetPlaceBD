package com.mycompany.controller;

import com.mycompany.service.UsuarioService;
import com.mycompany.model.Usuario;
import java.util.List;

public class UsuarioController {

    private final UsuarioService service = new UsuarioService();

    public void registrar(String nome, String email, String senha, String tipo) {
        service.registrarUsuario(nome, email, senha, tipo);
    }

    public boolean login(String email, String senha) {
        return service.login(email, senha);
    }

    // --------------------------
    // CRUD COMPLETO
    // --------------------------

    public Usuario buscarPorId(String id) {
        return service.buscarPorId(id);
    }

    public List<Usuario> listar() {
        return service.listar();
    }

    public void atualizar(Usuario u) {
        service.atualizar(u);
    }

    public void deletar(String id) {
        service.deletar(id);
    }
}
