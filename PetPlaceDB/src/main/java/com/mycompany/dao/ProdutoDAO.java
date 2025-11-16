package com.mycompany.dao;

import com.mycompany.factory.MySQLConnectionFactory;
import com.mycompany.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto p) {

        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, QUANTIDADE_ESTOQUE) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidadeEstoque());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Produto> listarTodos() {

        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM PRODUTO";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Produto p = new Produto();

                p.setIdProduto(rs.getString("idPRODUTO"));
                p.setNome(rs.getString("NOME"));
                p.setDescricao(rs.getString("DESCRICAO"));
                p.setPreco(rs.getDouble("PRECO"));
                p.setQuantidadeEstoque(rs.getInt("QUANTIDADE_ESTOQUE"));

                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
