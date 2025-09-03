package com.vans.backend.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;


@Entity
@Table(name = "RESERVAS")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservas_seq_gen")
    @SequenceGenerator(name = "reservas_seq_gen", sequenceName = "reservas_seq", allocationSize = 1)
    @Column(name = "reserva_id")
    private Integer reserva_id;
    private Integer viaje_id;
    private Integer usuario_id;
    private Integer asiento_id;
    private LocalDateTime fecha_reserva;
    private String estado;


    //constructor
    public Reserva() {
    }
    
    //getter y sett

    public Integer getReserva_id() {
        return reserva_id;
    }

    public Integer getViaje_id() {
        return viaje_id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public Integer getAsiento_id() {
        return asiento_id;
    }

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setReserva_id(Integer reserva_id) {
        this.reserva_id = reserva_id;
    }

    public void setViaje_id(Integer viaje_id) {
        this.viaje_id = viaje_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setAsiento_id(Integer asiento_id) {
        this.asiento_id = asiento_id;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
