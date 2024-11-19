package com.example.energia.repository;

import com.example.energia.model.PontoRecarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PontoRecargaRepository extends JpaRepository<PontoRecarga, Long> {

    // Método padrão do JpaRepository (findById)
    Optional<PontoRecarga> findById(Long id);

    // Busca personalizada pelo ID usando JPQL
    @Query("SELECT p FROM PontoRecarga p WHERE p.idPontoRecarga = :id")
    Optional<PontoRecarga> buscarPorId(@Param("id") Long id);

    // Verifica se um ponto de recarga existe pelo ID
    @Query("SELECT COUNT(p) > 0 FROM PontoRecarga p WHERE p.idPontoRecarga = :id")
    boolean existsByIdCustom(@Param("id") Long id);
}
