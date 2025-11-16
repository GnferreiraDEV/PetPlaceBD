package com.mycompany.dao;

import com.mycompany.factory.MySQLConnectionFactory;
import com.mycompany.model.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public void salvar(Servico s) {
        String sql = "INSERT INTO SERVICO (idSERVICO, DESCRICAO, PRECO, BANHO, TOSA) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getIdServico());
            ps.setString(2, s.getDescricao());
            ps.setDouble(3, s.getPreco());
            ps.setBoolean(4, s.isBanho());
            ps.setBoolean(5, s.isTosa());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao salvar serviço: " + e.getMessage());
        }
    }


    public List<Servico> listarTodos() {
        List<Servico> lista = new ArrayList<>();

        String sql = "SELECT * FROM SERVICO";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Servico s = new Servico();
                s.setIdServico(rs.getString("idSERVICO"));
                s.setDescricao(rs.getString("DESCRICAO"));
                s.setPreco(rs.getDouble("PRECO"));
                s.setBanho(rs.getBoolean("BANHO"));
                s.setTosa(rs.getBoolean("TOSA"));

                lista.add(s);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar serviços: " + e.getMessage());
        }

        return lista;
    }
}
