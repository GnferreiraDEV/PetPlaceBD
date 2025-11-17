package com.mycompany.controller;

import com.mycompany.model.Usuario;
import com.mycompany.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UsuarioApiController {

    private final UsuarioService service;
    @Autowired
    public UsuarioApiController(UsuarioService service) {
        this.service = service;
    }

    // Endpoint de Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciais) {
        String email = credenciais.get("login");
        String senha = credenciais.get("senha");

        boolean sucesso = service.login(email, senha);

        if (sucesso) {
            // BUSCA O USUÁRIO COMPLETO PARA RETORNAR OS DADOS DE PERMISSÃO
            // Você precisa ter criado o método 'buscarPorLogin' no Service (veja abaixo)
            Usuario u = service.buscarPorLogin(email);

            return ResponseEntity.ok().body(Map.of(
                    "mensagem", "Login realizado com sucesso!",
                    "autenticado", true,
                    "usuario", email,
                    "nome", u.getNome(),
                    "id_usuario", u.getId_usuario(), // <--- CRUCIAL: O Front-end vai guardar isso
                    "grupo", u.getId_grupo()         // <--- CRUCIAL: Para saber se é ADMIN
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "mensagem", "Login ou senha incorretos",
                    "autenticado", false
            ));
        }
    }

    // Endpoint de Registro
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Usuario u) {
        try {
            service.registrarUsuario(u.getNome(), u.getLogin(), u.getSenha(), u.getId_grupo());

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "mensagem", "Usuário cadastrado com sucesso!"
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "mensagem", "Erro ao cadastrar usuário: " + e.getMessage()
            ));
        }
    }
}