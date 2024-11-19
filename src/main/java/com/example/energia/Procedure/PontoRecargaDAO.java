package com.example.energia.Procedure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class PontoRecargaDAO {

    private final DataSource dataSource;

    @Autowired
    public PontoRecargaDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserirPontoRecarga(int idPontoRecarga, String nome, String endereco, double latitude, double longitude, String tipoConector, int potenciaMaxima, String disponibilidade, double precoPorKWh) {
        String sql = "{CALL inserir_Ponto_Recarga(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idPontoRecarga);
            stmt.setString(2, nome);
            stmt.setString(3, endereco);
            stmt.setDouble(4, latitude);
            stmt.setDouble(5, longitude);
            stmt.setString(6, tipoConector);
            stmt.setInt(7, potenciaMaxima);
            stmt.setString(8, disponibilidade);
            stmt.setDouble(9, precoPorKWh);

            stmt.execute();
            System.out.println("Ponto de Recarga inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir ponto de recarga: " + e.getMessage());
        }
    }
}
