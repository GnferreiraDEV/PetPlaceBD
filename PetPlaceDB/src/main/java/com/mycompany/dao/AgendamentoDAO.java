/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import factory.MongoConnectionFactory;
import model.Agendamento;
import org.bson.Document;

/**
 *
 * @author Gusavo
 */
public class AgendamentoDAO {
    
    

public class AgendamentoDAO {

    private final MongoCollection<Document> collection;

    public AgendamentoDAO() {
        MongoDatabase db = MongoConnectionFactory.getDatabase();
        this.collection = db.getCollection("agendamentos");
    }

    public void salvar(Agendamento ag) {
        Document doc = new Document("_id", ag.getId())
                .append("cpfCliente", ag.getCpfCliente())
                .append("idServico", ag.getIdServico())
                .append("data", ag.getData())
                .append("hora", ag.getHora())
                .append("formaPagamento", ag.getFormaPagamento())
                .append("valor", ag.getValor())
                .append("status", ag.getStatus());

        collection.insertOne(doc);
    }
    
}
