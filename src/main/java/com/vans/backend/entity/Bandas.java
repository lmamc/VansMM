package com.vans.backend.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "BANDAS")
public class Bandas {
    @Id
    @Column(name = "banda_id")
    private Integer banda_id;
    private String nombre;
    private String genero;
    private String pais_origen;
    private LocalDateTime fecha_Concierto;

    public Bandas() {
    }



    public Integer getBanda_Id() {
        return banda_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getPaisOrigen() {
        return pais_origen;
    }

    public LocalDateTime getFechaConcierto() {
        return fecha_Concierto;
    }

    public void setBanda_Id(Integer banda_id) {
        this.banda_id = banda_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPaisOrigen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

    public void setFechaConcierto(LocalDateTime fecha_Concierto) {
        this.fecha_Concierto = fecha_Concierto;
    }

    
}
