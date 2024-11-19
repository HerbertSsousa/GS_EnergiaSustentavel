package com.example.energia.model;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuarioss")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    @Column(name = "id_usuario")
    private Long idUsuario;



    @NotBlank
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;

    @Email
    @Size(max = 100)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Size(max = 100)
    @Column(name = "senha")
    private String senha;

    @Size(max = 50)
    @Column(name = "carro_modelo")
    private String carroModelo;

    @Column(name = "capacidade_bateria")
    private Integer capacidadeBateria;

    @Column(name = "autonomia_km")
    private Integer autonomiaKm;

    // Getters e Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCarroModelo() {
        return carroModelo;
    }

    public void setCarroModelo(String carroModelo) {
        this.carroModelo = carroModelo;
    }

    public Integer getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(Integer capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public Integer getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(Integer autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }



}
