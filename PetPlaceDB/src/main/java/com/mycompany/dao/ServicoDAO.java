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
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, s.getIdServico());
            stmt.setString(2, s.getDescricao());
            stmt.setDouble(3, s.getPreco());
            stmt.setBoolean(4, s.isBanho());
            stmt.setBoolean(5, s.isTosa());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar serviço: " + e.getMessage());
        }
    }

    public void atualizar(Servico s) {
        String sql = "UPDATE servico SET DESCRICAO=?, PRECO=?, BANHO=?, TOSA=? WHERE idSERVICO=?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, s.getDescricao());
            stmt.setDouble(2, s.getPreco());
            stmt.setBoolean(3, s.isBanho());
            stmt.setBoolean(4, s.isTosa());
            stmt.setString(5, s.getIdServico());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar serviço: " + e.getMessage());
        }
    }

    public void deletar(String id) {
        String sql = "DELETE FROM servico WHERE idSERVICO=?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar serviço: " + e.getMessage());
        }
    }

    public Servico buscarPorId(String id) {
        String sql = "SELECT * FROM servico WHERE idSERVICO=?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Servico(
                    rs.getString("idSERVICO"),
                    rs.getString("DESCRICAO"),
                    rs.getDouble("PRECO"),
                    rs.getBoolean("BANHO"),
                    rs.getBoolean("TOSA")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar serviço: " + e.getMessage());
        }
    }

    public List<Servico> listarTodos() {
        String sql = "SELECT * FROM servico";
        List<Servico> lista = new ArrayList<>();

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Servico(
                    rs.getString("idSERVICO"),
                    rs.getString("DESCRICAO"),
                    rs.getDouble("PRECO"),
                    rs.getBoolean("BANHO"),
                    rs.getBoolean("TOSA")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar serviços: " + e.getMessage());
        }

        return lista;
    }
}
