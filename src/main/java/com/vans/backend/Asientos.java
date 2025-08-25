package com.vans.backend;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name = "ASIENTOS")
public class Asientos {
    @Id
    @Column(name = "asiento_id")
    private Integer asiento_id;
    private Integer vehiculo_id;
    private Integer numero_asiento;
    private String estado;


    public Asientos() {
    }

    public Integer getAsientoId() {
        return asiento_id;
    }

    public Integer getVehiculoId() {
        return vehiculo_id;
    }

    public Integer getNumeroAsiento() {
        return numero_asiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setAsientoId(Integer asiento_id) {
        this.asiento_id = asiento_id;
    }

    public void setVehiculoId(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public void setNumeroAsiento(Integer numero_asiento) {
        this.numero_asiento = numero_asiento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
