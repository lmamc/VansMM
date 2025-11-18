package com.vans.backend.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculos_seq_gen")
    @SequenceGenerator(name = "vehiculos_seq_gen", sequenceName = "vehiculos_seq", allocationSize = 1)
    @Column(name = "vehiculo_id")
    @JsonProperty("vehiculo_id")
    private Integer vehiculo_id;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa; */


    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference("empresa-vehiculos")
    private Empresa empresa;

    @OneToMany(mappedBy = "vehiculo")
    @JsonIgnore
    private List<Viajes> viajes;

    @OneToMany(mappedBy = "vehiculo")
    @JsonManagedReference("vehiculo-asientos")
    private List<Asientos> asientos;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "patente")
    private String patente;

    @Column(name = "estado")
    private String estado;

    public Vehiculo() {
    }

    // --- GETTERS Y SETTERS CORREGIDOS ---

    public Integer getVehiculo_id() {
        return vehiculo_id;
    }

    public void setVehiculo_id(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Viajes> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viajes> viajes) {
        this.viajes = viajes;
    }

    public List<Asientos> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asientos> asientos) {
        this.asientos = asientos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}