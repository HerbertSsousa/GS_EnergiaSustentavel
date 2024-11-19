package com.example.energia.repository;

import com.example.energia.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar um usuário por e-mail
    Usuario findByEmail(String email);

    // Método para buscar um usuário por nome (pode ser útil para buscas parciais, caso use @Query)
    Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    // Método para buscar um usuário por id (já presente no JpaRepository)
    Optional<Usuario> findById(Long id);

    // Método para buscar um usuário por nome (não paginado, retorna um único usuário)
    Optional<Usuario> findByNome(String nome);

    // Método para excluir um usuário por id (já presente no JpaRepository)
    void deleteById(Long id);

    // Método para buscar por capacidade de bateria e autonomia (exemplo de filtro)
    Page<Usuario> findByCapacidadeBateriaGreaterThanAndAutonomiaKmGreaterThan(
            Integer capacidadeBateria, Integer autonomiaKm, Pageable pageable);

    // Método para buscar todos os usuários com uma capacidade mínima de bateria
    Page<Usuario> findByCapacidadeBateriaGreaterThan(Integer capacidadeBateria, Pageable pageable);
}
