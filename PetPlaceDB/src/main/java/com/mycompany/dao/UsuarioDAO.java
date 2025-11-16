/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mycompany.factory.MongoConnectionFactory;
import com.mycompany.model.Usuario;
import org.bson.Document;


/**
 *
 * @author Gustavo
 */

public class UsuarioDAO {

    private final MongoCollection<Document> collection;

    public UsuarioDAO() {
        MongoDatabase db = MongoConnectionFactory.getDatabase();
        this.collection = db.getCollection("usuarios");
    }

    public void salvar(Usuario u) {
        Document doc = new Document("_id", u.getId())
                .append("nome", u.getNome())
                .append("email", u.getEmail())
                .append("senhaHash", u.getSenhaHash())
                .append("tipo", u.getTipo());

        collection.insertOne(doc);
    }

    public Document buscarPorEmail(String email) {
        return collection.find(Filters.eq("email", email)).first();
    }
}
