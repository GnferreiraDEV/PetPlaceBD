package com.mycompany.dao;

import com.mycompany.factory.MySQLConnectionFactory;
import com.mycompany.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto p) {
        String sql = "INSERT INTO PRODUTO (idPRODUTO, NOME, DESCRICAO, PRECO, QUANTIDADE_ESTOQUE) VALUES (gerar_id('PROD'), ?, ?, ?, ?);";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public void atualizar(Produto p) {
        String sql = "UPDATE PRODUTO SET NOME=?, DESCRICAO=?, PRECO=?, QUANTIDADE_ESTOQUE=? WHERE idPRODUTO=?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setString(5, p.getIdProduto());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public void deletar(String id) {
        String sql = "DELETE FROM PRODUTO WHERE idPRODUTO=?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
        }
    }

    public Produto buscarPorId(String id) {
        String sql = "SELECT * FROM PRODUTO WHERE idPRODUTO=?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                    rs.getString("idPRODUTO"),
                    rs.getString("NOME"),
                    rs.getString("DESCRICAO"),
                    rs.getDouble("PRECO"),
                    rs.getInt("QUANTIDADE_ESTOQUE")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Produto(
                    rs.getString("idPRODUTO"),
                    rs.getString("NOME"),
                    rs.getString("DESCRICAO"),
                    rs.getDouble("PRECO"),
                    rs.getInt("QUANTIDADE_ESTOQUE")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }
}
