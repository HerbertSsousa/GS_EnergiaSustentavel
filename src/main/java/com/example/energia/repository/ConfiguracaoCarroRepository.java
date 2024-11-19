package com.example.energia.repository;

import com.example.energia.model.ConfiguracaoCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoCarroRepository extends JpaRepository<ConfiguracaoCarro, Long> {
}
