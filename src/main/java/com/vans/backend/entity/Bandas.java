package com.vans.backend.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "BANDAS")
public class Bandas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bandas_seq_gen")
    @SequenceGenerator(name = "bandas_seq_gen", sequenceName = "bandas_seq", allocationSize = 1)
    @Column(name = "banda_id")
    private Integer banda_id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "PAIS_ORIGEN")
    private String paisOrigen;

    public Bandas() {
    }

    public Integer getBanda_id() {
        return banda_id;
    }

    public void setBanda_id(Integer banda_id) {
        this.banda_id = banda_id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}