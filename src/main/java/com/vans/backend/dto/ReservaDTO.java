package com.vans.backend.dto;

import java.time.LocalDateTime;

public class ReservaDTO {
    private Integer usuario_id;
    private Integer viaje_id;
    private Integer asiento_id;
    private LocalDateTime fecha_reserva;
    private String estado;

    // Getters y Setters
    public Integer getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getViaje_id() {
        return viaje_id;
    }
    public void setViaje_id(Integer viaje_id) {
        this.viaje_id = viaje_id;
    }

    public Integer getAsiento_id() {
        return asiento_id;
    }
    public void setAsiento_id(Integer asiento_id) {
        this.asiento_id = asiento_id;
    }

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }
    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}