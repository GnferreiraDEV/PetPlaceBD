package com.mycompany.controller;

import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra;
import com.mycompany.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa todas as anotações web

import java.util.List;

@RestController // 1. Diz ao Spring que é um Controller de API (retorna JSON)
@RequestMapping("/api/compras") // 2. Define o endereço base (ex: /api/compras)
public class CompraApiController {

    // 3. Injeta o CompraService que acabamos de modernizar
    private final CompraService service;

    @Autowired
    public CompraApiController(CompraService service) {
        this.service = service;
    }

    // --- ENDPOINTS ---

    // CREATE (POST /api/compras)
    @PostMapping
    public void registrar(@RequestBody Compra compra) {
        // 4. @RequestBody converte o JSON enviado para um objeto Compra

        // 5. Precisamos converter a Lista de Itens para o formato varargs (...)
        //    que o seu serviço espera.
        ItemCompra[] itensArray = compra.getItens().toArray(new ItemCompra[0]);

        service.registrarCompra(
                compra.getCpfCliente(),
                itensArray // 6. Passa os itens para o serviço
        );
    }

    // NOTA: Se você quiser um endpoint para LISTAR compras, você
    // precisará criar um JpaRepository para Compra e um método
    // "listar" no seu CompraService.
}