package com.vans.backend.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "CONCIERTOS")
public class Conciertos {
    @Id
    @Column(name = "concierto_id")
    private Integer concierto_id;
    private Integer empresa_id;
    private Integer banda_id;
    private String direccion;
    private LocalDateTime fecha;


    public Conciertos() {
    }

    public Integer getConcierto_id() {
        return concierto_id;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public Integer getBanda_id() {
        return banda_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setConcierto_id(Integer concierto_id) {
        this.concierto_id = concierto_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setBanda_id(Integer banda_id) {
        this.banda_id = banda_id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
