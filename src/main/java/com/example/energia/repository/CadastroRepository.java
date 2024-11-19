package com.example.energia.repository;

import com.example.energia.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    // Método para buscar todos os cadastros
    // O JpaRepository já fornece o método findAll() que retorna uma lista de cadastros
    // Não é necessário implementar nada aqui para listar todos

    // Método para buscar um cadastro pelo email (opcional, caso você precise)
    Optional<Cadastro> findByEmail(String email);

    // Método para verificar se um cadastro existe com o email (opcional)
    boolean existsByEmail(String email);

    // Método para excluir um cadastro pelo email (opcional)
    void deleteByEmail(String email);

    // Método para buscar um cadastro pelo ID (já disponível no JpaRepository)
    Optional<Cadastro> findById(Long id);
}
