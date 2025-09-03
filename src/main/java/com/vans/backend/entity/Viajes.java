package com.vans.backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;


@Entity
@Table(name = "VIAJES")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viajes_seq_gen")
    @SequenceGenerator(name = "viajes_seq_gen", sequenceName = "viajes_seq", allocationSize = 1)
    @Column(name = "viaje_id")
    private Integer viaje_id;
    private Integer vehiculo_id;
    private Integer concierto_id;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaLlegada;
    private String estado;


    //constructor
    public Viajes() {

    }

    //getters y setter 
    public Integer getViaje_id() {
        return viaje_id;
    }

    public Integer getVehiculo_id() {
        return vehiculo_id;
    }

    public Integer getConcierto_id() {
        return concierto_id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public String getEstado() {
        return estado;
    }

    public void setViaje_id(Integer viaje_id) {
        this.viaje_id = viaje_id;
    }

    public void setVehiculo_id(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public void setConcierto_id(Integer concierto_id) {
        this.concierto_id = concierto_id;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
