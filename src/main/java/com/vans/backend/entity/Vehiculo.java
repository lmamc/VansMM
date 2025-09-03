package com.vans.backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculos_seq_gen")
    @SequenceGenerator(name = "vehiculos_seq_gen", sequenceName = "vehiculos_seq", allocationSize = 1)
    @Column(name = "vehiculo_id")
    private Integer vehiculo_id;
    private Integer concierto_id;
    private Integer empresa_id;
    private String modelo;
    private Integer capacidad;
    private String patente;
    private String estado;

    // Constructor (opcional)
    public Vehiculo(){}

    // Getters y setters

    public Integer getVehiculo_id() {
        return vehiculo_id;
    }

    public Integer getConcierto_id() {
        return concierto_id;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public String getPatente() {
        return patente;
    }

    public String getEstado() {
        return estado;
    }
    
    public void setVehiculo_id(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public void setConcierto_id(Integer concierto_id) {
        this.concierto_id = concierto_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
