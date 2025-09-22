package com.vans.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class VehiculoDTO {
    private Integer vehiculo_id;
    private String modelo;
    private Integer capacidad;
    private String patente;
    private String estado;
    public void setTipo(String modelo2) {
        throw new UnsupportedOperationException("Unimplemented method 'setTipo'");
    }
}