package com.example.energia.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConfiguracaoCarroDTO {

    private Long idConfiguracaoCarro;

    @NotNull
    private Long idUsuario;

    @Size(max = 50)
    private String carroModelo;

    private Integer autonomiaCompleta;

    private Double consumoPorKm;

    // Getters e Setters
    public Long getIdConfiguracaoCarro() {
        return idConfiguracaoCarro;
    }

    public void setIdConfiguracaoCarro(Long idConfiguracaoCarro) {
        this.idConfiguracaoCarro = idConfiguracaoCarro;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCarroModelo() {
        return carroModelo;
    }

    public void setCarroModelo(String carroModelo) {
        this.carroModelo = carroModelo;
    }

    public Integer getAutonomiaCompleta() {
        return autonomiaCompleta;
    }

    public void setAutonomiaCompleta(Integer autonomiaCompleta) {
        this.autonomiaCompleta = autonomiaCompleta;
    }

    public Double getConsumoPorKm() {
        return consumoPorKm;
    }

    public void setConsumoPorKm(Double consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }
}
