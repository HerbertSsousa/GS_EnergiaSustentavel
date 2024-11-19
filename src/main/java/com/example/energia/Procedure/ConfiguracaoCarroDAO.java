package com.example.energia.Procedure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class ConfiguracaoCarroDAO {

    private final DataSource dataSource;

    @Autowired
    public ConfiguracaoCarroDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserirConfiguracaoCarro(int idConfiguracaoCarro, int idUsuario, String carroModelo, int autonomiaCompleta, double consumoPorKm) {
        String sql = "{CALL inserir_Configuracao_Carro(?, ?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idConfiguracaoCarro);
            stmt.setInt(2, idUsuario);
            stmt.setString(3, carroModelo);
            stmt.setInt(4, autonomiaCompleta);
            stmt.setDouble(5, consumoPorKm);

            stmt.execute();
            System.out.println("Configuração de Carro inserida com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir configuração de carro: " + e.getMessage());
        }
    }
}

