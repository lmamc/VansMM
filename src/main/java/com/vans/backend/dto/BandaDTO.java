package com.vans.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandaDTO {
    private Integer banda_id;
    private String nombre;
    private String genero;
    private String paisOrigen;
}
