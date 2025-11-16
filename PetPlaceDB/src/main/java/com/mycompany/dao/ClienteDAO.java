package com.mycompany.dao;

import com.mycompany.factory.MySQLConnectionFactory;
import com.mycompany.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void salvar(Cliente c) {
        String sql = "INSERT INTO CLIENTE (CPF, NOME, TELEFONE, EMAIL, ENDERECO) VALUES (?,?,?,?,?)";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCpf());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getEndereco());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarPorCPF(String cpf) {
        String sql = "SELECT * FROM CLIENTE WHERE CPF = ?";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("CPF"));
                c.setNome(rs.getString("NOME"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setEmail(rs.getString("EMAIL"));
                c.setEndereco(rs.getString("ENDERECO"));
                return c;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";

        try (Connection conn = MySQLConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("CPF"));
                c.setNome(rs.getString("NOME"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setEmail(rs.getString("EMAIL"));
                c.setEndereco(rs.getString("ENDERECO"));
                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
