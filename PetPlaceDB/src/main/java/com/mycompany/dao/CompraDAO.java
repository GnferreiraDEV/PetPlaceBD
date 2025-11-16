package com.mycompany.dao;

import com.mycompany.factory.MySQLConnectionFactory;
import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraDAO {

    public void salvar(Compra compra) {

        try (Connection conn = MySQLConnectionFactory.getConnection()) {

            // 1) INSERE A COMPRA
            String sqlCompra = "INSERT INTO COMPRA (idCOMPRA, CPF, DATA_COMPRA, VALOR_TOTAL) "
                    + "VALUES (?, ?, NOW(), ?)";

            PreparedStatement ps = conn.prepareStatement(sqlCompra);
            ps.setString(1, compra.getIdCompra());
            ps.setString(2, compra.getCpfCliente());
            ps.setDouble(3, compra.getValorTotal());
            ps.executeUpdate();

            // 2) INSERE OS ITENS
            String sqlItem = "INSERT INTO COMPRA_has_PRODUTO "
                    + " (COMPRA_idCOMPRA, PRODUTO_idPRODUTO, QUANTIDADE)"
                    + " VALUES (?, ?, ?)";

            for (ItemCompra item : compra.getItens()) {
                PreparedStatement psi = conn.prepareStatement(sqlItem);
                psi.setString(1, compra.getIdCompra());
                psi.setString(2, item.getIdProduto());
                psi.setInt(3, item.getQuantidade());
                psi.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
