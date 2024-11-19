package com.example.energia.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Pontos_Recarga")
public class PontoRecarga {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto_recarga_seq")
    @SequenceGenerator(name = "ponto_recarga_seq", sequenceName = "ponto_recarga_seq", allocationSize = 1)
    @Column(name = "id_ponto_recarga")
    private Long idPontoRecarga;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Size(max = 255)
    @Column(name = "endereco")
    private String endereco;

    @NotNull
    @Column(name = "latitude")
    private Number latitude;

    @NotNull
    @Column(name = "longitude")
    private Number longitude;

    @Size(max = 50)
    @Column(name = "tipo_conector")
    private String tipoConector;

    @Column(name = "potencia_maxima")
    private Integer potenciaMaxima;

    @Size(max = 50)
    @Column(name = "disponibilidade")
    private String disponibilidade;

    @Column(name = "preco_por_kwh") // Aspas duplas para Oracle
    private Number precoPorKWh;

    // Getters e Setters

    public Long getIdPontoRecarga() {
        return idPontoRecarga;
    }

    public void setIdPontoRecarga(Long idPontoRecarga) {
        this.idPontoRecarga = idPontoRecarga;
    }

    public @NotBlank @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @Size(max = 100) String nome) {
        this.nome = nome;
    }

    public @NotBlank @Size(max = 255) String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank @Size(max = 255) String endereco) {
        this.endereco = endereco;
    }

    public @NotNull Number getLatitude() {
        return latitude;
    }

    public void setLatitude(@NotNull Number latitude) {
        this.latitude = latitude;
    }

    public @NotNull Number getLongitude() {
        return longitude;
    }

    public void setLongitude(@NotNull Number longitude) {
        this.longitude = longitude;
    }

    public @Size(max = 50) String getTipoConector() {
        return tipoConector;
    }

    public void setTipoConector(@Size(max = 50) String tipoConector) {
        this.tipoConector = tipoConector;
    }

    public Integer getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(Integer potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public @Size(max = 50) String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(@Size(max = 50) String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Number getPrecoPorKWh() {
        return precoPorKWh;
    }

    public void setPrecoPorKWh(Number precoPorKWh) {
        this.precoPorKWh = precoPorKWh;
    }
}
