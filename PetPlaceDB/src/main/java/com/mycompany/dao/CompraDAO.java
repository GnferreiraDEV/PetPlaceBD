package com.mycompany.dao;

import com.mycompany.factory.MySQLConnectionFactory;
import com.mycompany.model.Compra;
import com.mycompany.model.ItemCompra;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CompraDAO {

    public void salvar(Compra compra) {

        try (Connection conn = MySQLConnectionFactory.getConnection()) {

            String sqlCompra = "{CALL registrar_compra(?, ?, ?)}"; // 3º parâmetro é OUT
            try (CallableStatement cs = conn.prepareCall(sqlCompra)) {
                cs.setString(1, compra.getCpfCliente());
                cs.setDouble(2, compra.getValorTotal());
                cs.registerOutParameter(3, Types.VARCHAR); // OUT param para id
                cs.executeUpdate();

                String idGerado = cs.getString(3);
                compra.setIdCompra(idGerado);
            }

            String sqlItem = "INSERT INTO COMPRA_has_PRODUTO "
                    + "(COMPRA_idCOMPRA, PRODUTO_idPRODUTO, QUANTIDADE) VALUES (?, ?, ?)";

            for (ItemCompra item : compra.getItens()) {
                try (CallableStatement psi = conn.prepareCall(sqlItem)) {
                    psi.setString(1, compra.getIdCompra());
                    psi.setString(2, item.getIdProduto());
                    psi.setInt(3, item.getQuantidade());
                    psi.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar compra: " + e.getMessage());
        }
    }
}
