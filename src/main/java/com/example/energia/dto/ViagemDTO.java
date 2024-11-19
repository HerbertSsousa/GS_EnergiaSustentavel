package com.example.energia.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ViagemDTO {

    private Long idViagem;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long idUsuario;

    @NotNull(message = "A origem é obrigatória.")
    private String origem;

    @NotNull(message = "O destino é obrigatório.")
    private String destino;

    @NotNull(message = "A data da viagem é obrigatória.")
    private LocalDate dataViagem;

    private Double distanciaTotal;
    private String status;

    // Getters e Setters
    public Long getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Long idViagem) {
        this.idViagem = idViagem;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(LocalDate dataViagem) {
        this.dataViagem = dataViagem;
    }

    public Double getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(Double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
