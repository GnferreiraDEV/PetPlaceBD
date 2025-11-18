package com.mycompany.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mycompany.factory.MongoConnectionFactory;
import com.mycompany.model.Agendamento;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    private final MongoCollection<Document> collection;

    public AgendamentoDAO() {
        MongoDatabase db = MongoConnectionFactory.getDatabase();
        this.collection = db.getCollection("agendamentos");
    }


    public void salvar(Agendamento ag) {
        Document doc = new Document("_id", ag.getIdAgendamento())
                .append("cpfCliente", ag.getCpfCliente())
                .append("idServico", ag.getIdServico())
                .append("data", ag.getDataAgendamento())
                .append("hora", ag.getHoraAgendamento())
                .append("valor", ag.getValor())
                .append("formaPagamento", ag.getFormaPagamento())
                .append("status", ag.getStatus());

        collection.insertOne(doc);
    }


    public void atualizar(Agendamento ag) {
        Bson filtro = Filters.eq("_id", ag.getIdAgendamento());

        Document atualizacao = new Document("$set", new Document()
                .append("cpfCliente", ag.getCpfCliente())
                .append("idServico", ag.getIdServico())
                .append("data", ag.getDataAgendamento())
                .append("hora", ag.getHoraAgendamento())
                .append("valor", ag.getValor())
                .append("formaPagamento", ag.getFormaPagamento())
                .append("status", ag.getStatus())
        );

        collection.updateOne(filtro, atualizacao);
    }


    public void deletar(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }


    public Agendamento buscarPorId(String id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();
        if (doc == null) return null;

        return new Agendamento(
                doc.getString("_id"),
                doc.getString("cpfCliente"),
                doc.getString("idServico"),
                doc.getString("data"),
                doc.getString("hora"),
                doc.getDouble("valor"),
                doc.getString("formaPagamento"),
                doc.getString("status")
        );
    }

    public List<Agendamento> listarTodos() {
        List<Agendamento> lista = new ArrayList<>();

        for (Document doc : collection.find()) {
            lista.add(new Agendamento(
                    doc.getString("_id"),
                    doc.getString("cpfCliente"),
                    doc.getString("idServico"),
                    doc.getString("data"),
                    doc.getString("hora"),
                    doc.getDouble("valor"),
                    doc.getString("formaPagamento"),
                    doc.getString("status")
            ));
        }

        return lista;
    }
}
