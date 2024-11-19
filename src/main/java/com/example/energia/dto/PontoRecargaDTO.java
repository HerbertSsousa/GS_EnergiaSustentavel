package com.example.energia.dto;

public class PontoRecargaDTO {

    private Long idPontoRecarga;
    private String nome;
    private String endereco;
    private Number latitude;
    private Number longitude;
    private String tipoConector;
    private Integer potenciaMaxima;
    private String disponibilidade;
    private Number precoPorKWh;

    // Getters e Setters

    public Long getIdPontoRecarga() {
        return idPontoRecarga;
    }

    public void setIdPontoRecarga(Long idPontoRecarga) {
        this.idPontoRecarga = idPontoRecarga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Number getLatitude() {
        return latitude;
    }

    public void setLatitude(Number latitude) {
        this.latitude = latitude;
    }

    public Number getLongitude() {
        return longitude;
    }

    public void setLongitude(Number longitude) {
        this.longitude = longitude;
    }

    public String getTipoConector() {
        return tipoConector;
    }

    public void setTipoConector(String tipoConector) {
        this.tipoConector = tipoConector;
    }

    public Integer getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(Integer potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Number getPrecoPorKWh() {
        return precoPorKWh;
    }

    public void setPrecoPorKWh(Number precoPorKWh) {
        this.precoPorKWh = precoPorKWh;
    }


}
