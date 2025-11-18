package com.mycompany.service;

import com.mycompany.model.Cliente;
import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra; // Classe auxiliar dos itens
import com.mycompany.model.Usuario;
import com.mycompany.repository.ClienteRepository;
import com.mycompany.repository.CompraRepository;
import com.mycompany.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CompraService {

    @Autowired private CompraRepository repository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private ClienteRepository clienteRepository;

    // =====================================================================
    // 1. REALIZAR VENDA (O método que estava faltando!)
    // =====================================================================
    @Transactional // Garante que salva tudo ou nada
    public void realizarCompra(Compra compra) {

        // A. Gera ID único e Data
        String idUnico = "CP_" + UUID.randomUUID().toString().substring(0, 8);
        compra.setIdCompra(idUnico);

        // Se a data não vier do front, usa a de hoje
        if (compra.getDataCompra() == null) {
            compra.setDataCompra(LocalDate.now().toString());
        }

        // B. Salva o Cabeçalho da Compra
        repository.save(compra);

        // C. Salva os Itens um por um na tabela de ligação
        if (compra.getItens() != null) {
            for (ItemCompra item : compra.getItens()) {
                repository.salvarItemCompra(
                        idUnico,
                        item.getIdProduto(),
                        item.getQuantidade()
                );
            }
        }
    }

    // =====================================================================
    // 2. LISTAR (Com filtro de segurança)
    // =====================================================================
    public List<Compra> listarPorPermissao(String userId) {
        Usuario u = usuarioRepository.findById(userId).orElse(null);
        if (u == null) return Collections.emptyList();

        // Se for ADMIN, vê tudo
        if ("ADMIN".equalsIgnoreCase(u.getId_grupo())) {
            return repository.findAll();
        }

        // Se for CLIENTE, vê só o dele
        Cliente c = clienteRepository.findByEmail(u.getLogin());
        if (c != null) {
            return repository.findByCpfCliente(c.getCpf());
        }
        return Collections.emptyList();
    }

    // Método auxiliar caso precise listar tudo sem filtro (opcional)
    public List<Compra> listarTodas() {
        return repository.findAll();
    }
}