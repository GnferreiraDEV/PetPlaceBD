package com.mycompany.service;

import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra;
import com.mycompany.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Transactional // Garante que ou salva tudo, ou não salva nada
    public void realizarCompra(Compra compra) {

        // 1. Prepara o Cabeçalho da Compra
        String idUnico = "CP_" + UUID.randomUUID().toString().substring(0, 8);
        compra.setIdCompra(idUnico);
        compra.setDataCompra(LocalDate.now().toString()); // Data de hoje

        // 2. Salva a Compra (Tabela COMPRA)
        repository.save(compra);

        // 3. Salva os Itens (Tabela COMPRA_has_PRODUTO)
        // Varre a lista que veio do Front-end
        for (ItemCompra item : compra.getItens()) {
            repository.salvarItemCompra(
                    idUnico,
                    item.getIdProduto(),
                    item.getQuantidade()
            );
        }

        // Obs: Sua Trigger no banco vai baixar o estoque automaticamente!
    }
}