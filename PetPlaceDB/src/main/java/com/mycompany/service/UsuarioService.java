/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.UsuarioDAO;
import com.mycompany.model.Usuario;
import java.security.MessageDigest;
import java.util.UUID;

/**
 *
 * @author Gustavo
 */


public class UsuarioService {

    private final UsuarioDAO dao = new UsuarioDAO();

    public void registrarUsuario(String nome, String email, String senha, String tipo) {

        Usuario u = new Usuario();
        u.setId(UUID.randomUUID().toString());
        u.setNome(nome);
        u.setEmail(email);
        u.setSenhaHash(gerarHash(senha));
        u.setTipo(tipo);

        dao.salvar(u);
    }

    public boolean login(String email, String senha) {

        var doc = dao.buscarPorEmail(email);

        if (doc == null) return false;

        String senhaHash = gerarHash(senha);

        return senhaHash.equals(doc.getString("senhaHash"));
    }

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
