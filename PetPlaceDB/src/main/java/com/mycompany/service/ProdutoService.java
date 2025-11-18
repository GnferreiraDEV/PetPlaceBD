package com.mycompany.service;

import com.mycompany.model.Produto;
import com.mycompany.model.ProdutoMongo;
import com.mycompany.repository.ProdutoRepository;
import com.mycompany.repository.ProdutoMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository mysqlRepository;

    @Autowired
    private ProdutoMongoRepository mongoRepository;

    public List<Produto> listarTodos() {
        return mysqlRepository.findAll();
    }

    public Produto buscarPorId(String id) {
        return mysqlRepository.findById(id).orElse(null);
    }

    public Produto salvar(Produto p) {
        if (p.getIdProduto() == null || p.getIdProduto().isEmpty()) {
            String idGerado = "PROD_" + UUID.randomUUID().toString().substring(0, 8);
            p.setIdProduto(idGerado);
        }

        Produto salvoMysql = mysqlRepository.save(p);

        try {
            ProdutoMongo copia = new ProdutoMongo();
            copia.setNome(salvoMysql.getNome());
            copia.setDescricao(salvoMysql.getDescricao());
            copia.setPreco(salvoMysql.getPreco());

            copia.setQuantidadeEstoque(salvoMysql.getQuantidadeEstoque());

            copia.setIdMysql(salvoMysql.getIdProduto());

            mongoRepository.save(copia);
            System.out.println(">>> Sucesso: Salvo no MySQL e Mongo!");

        } catch (Exception e) {
            System.err.println(">>> Aviso: Salvo no MySQL, mas erro no Mongo: " + e.getMessage());
        }

        return salvoMysql;
    }

    public void deletar(String id) {
        mysqlRepository.deleteById(id);
    }
}