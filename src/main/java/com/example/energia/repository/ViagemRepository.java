package com.example.energia.repository;

import com.example.energia.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    /**
     * Encontra todas as viagens associadas a um usuário específico.
     * @param idUsuario ID do usuário.
     * @return Lista de viagens associadas ao usuário.
     */
    List<Viagem> findByUsuarioIdUsuario(Long idUsuario);

    /**
     * Encontra todas as viagens com status específico.
     * @param status Status da viagem (por exemplo, "Concluída", "Pendente").
     * @return Lista de viagens com o status informado.
     */
    List<Viagem> findByStatus(String status);

    /**
     * Encontra todas as viagens realizadas entre duas datas.
     * @param dataInicio Data inicial (inclusive).
     * @param dataFim Data final (inclusive).
     * @return Lista de viagens realizadas nesse intervalo.
     */
    List<Viagem> findByDataViagemBetween(LocalDate dataInicio, LocalDate dataFim);

    /**
     * Encontra todas as viagens que partiram de uma origem específica.
     * @param origem Origem da viagem.
     * @return Lista de viagens com a origem informada.
     */
    List<Viagem> findByOrigemContainingIgnoreCase(String origem);

    /**
     * Encontra todas as viagens que têm um destino específico.
     * @param destino Destino da viagem.
     * @return Lista de viagens com o destino informado.
     */
    List<Viagem> findByDestinoContainingIgnoreCase(String destino);

    /**
     * Encontra todas as viagens cuja distância total seja maior ou igual ao valor informado.
     * @param distanciaTotal Distância mínima.
     * @return Lista de viagens correspondentes.
     */
    List<Viagem> findByDistanciaTotalGreaterThanEqual(Double distanciaTotal);
}
