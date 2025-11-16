/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.factory.MongoConnectionFactory;
import com.mycompany.model.Produto;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author Gustavo
 */

public class ProdutoDAO {

    private final MongoCollection<Document> collection;

    public ProdutoDAO() {
        MongoDatabase db = MongoConnectionFactory.getDatabase();
        this.collection = db.getCollection("produtos");
    }

    public void salvar(Produto p) {
        Document doc = new Document("_id", p.getId())
                .append("nome", p.getNome())
                .append("descricao", p.getDescricao())
                .append("preco", p.getPreco())
                .append("estoque", p.getEstoque());

        collection.insertOne(doc);
    }

    public Produto buscarPorId(String id) {

        Document d = collection.find(eq("_id", id)).first();
        if (d == null) return null;

        Produto p = new Produto();
        p.setId(d.getString("_id"));
        p.setNome(d.getString("nome"));
        p.setDescricao(d.getString("descricao"));
        p.setPreco(d.getDouble("preco"));
        p.setEstoque(d.getInteger("estoque"));

        return p;
    }

    public void atualizar(Produto p) {

        Document doc = new Document("_id", p.getId())
                .append("nome", p.getNome())
                .append("descricao", p.getDescricao())
                .append("preco", p.getPreco())
                .append("estoque", p.getEstoque());

        collection.replaceOne(eq("_id", p.getId()), doc);
    }

    public void remover(String id) {
        collection.deleteOne(eq("_id", id));
    }
}
    
