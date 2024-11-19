package com.example.energia.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Configuracoes_Carro")
public class ConfiguracaoCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuracao_carro_seq")
    @SequenceGenerator(name = "configuracao_carro_seq", sequenceName = "configuracao_carro_seq", allocationSize = 1)
    @Column(name = "id_configuracao_carro")
    private Long idConfiguracaoCarro;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Size(max = 50)
    @Column(name = "carro_modelo")
    private String carroModelo;

    @Column(name = "autonomia_completa")
    private Integer autonomiaCompleta;

    @Column(name = "consumo_por_km")
    private Double consumoPorKm;

    // Getters e Setters
    public Long getIdConfiguracaoCarro() {
        return idConfiguracaoCarro;
    }

    public void setIdConfiguracaoCarro(Long idConfiguracaoCarro) {
        this.idConfiguracaoCarro = idConfiguracaoCarro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
