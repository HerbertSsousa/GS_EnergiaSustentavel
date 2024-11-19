package com.example.energia.Procedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class UsuarioDAO {

    private final DataSource dataSource;

    @Autowired
    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserirUsuario(int idUsuario, String nome, String email, String senha, String carroModelo, int capacidadeBateria, int autonomiaKm) {
        String sql = "{CALL inserir_Usuario(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, senha);
            stmt.setString(5, carroModelo);
            stmt.setInt(6, capacidadeBateria);
            stmt.setInt(7, autonomiaKm);

            stmt.execute();
            System.out.println("Usuário inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }
}
