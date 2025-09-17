package com.vans.backend.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ViajeDTO {
    private Integer viaje_id;
    private String origen;
    private String destino;
    private Double precio;
    private Integer asientos_disponibles;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private String estado;
    private VehiculoDTO vehiculo;
    private String empresa;
}