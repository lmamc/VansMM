package com.vans.backend.dto;

public class AsientoDTO {
    private Integer asiento_id;
    private String numero;
    private String estado;

    public AsientoDTO() {}

    public AsientoDTO(Integer asiento_id, String numero, String estado) {
        this.asiento_id = asiento_id;
        this.numero = numero;
        this.estado = estado;
    }

    public Integer getAsiento_id() {
        return asiento_id;
    }
    public void setAsiento_id(Integer asiento_id) {
        this.asiento_id = asiento_id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}