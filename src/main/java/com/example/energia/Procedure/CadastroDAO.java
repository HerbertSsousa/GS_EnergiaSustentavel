package com.example.energia.Procedure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class CadastroDAO {

    private final DataSource dataSource;

    @Autowired
    public CadastroDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserirCadastro(int idCadastro, String nome, String email, String senha, String telefone, String endereco) {
        String sql = "{CALL inserir_Cadastro(?, ?, ?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCadastro);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, senha);
            stmt.setString(5, telefone);
            stmt.setString(6, endereco);

            stmt.execute();
            System.out.println("Cadastro inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cadastro: " + e.getMessage());
        }
    }
}
