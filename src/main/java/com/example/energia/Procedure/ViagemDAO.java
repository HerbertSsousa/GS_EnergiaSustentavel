package com.example.energia.Procedure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class ViagemDAO {

    private final DataSource dataSource;

    @Autowired
    public ViagemDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserirViagem(int idViagem, int idUsuario, String origem, String destino, java.sql.Date dataViagem, int distanciaTotal, String status) {
        String sql = "{CALL inserir_Viagem(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idViagem);
            stmt.setInt(2, idUsuario);
            stmt.setString(3, origem);
            stmt.setString(4, destino);
            stmt.setDate(5, dataViagem);
            stmt.setInt(6, distanciaTotal);
            stmt.setString(7, status);

            stmt.execute();
            System.out.println("Viagem inserida com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir viagem: " + e.getMessage());
        }
    }
}
