package com.vans.backend.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Conciertos;
import com.vans.backend.service.ConciertosService;

@RestController
@RequestMapping("/conciertos")
@CrossOrigin(origins = "http://localhost:8100")

public class ConciertosController {
    private final ConciertosService conciertosService;

    public ConciertosController(ConciertosService conciertosService) {
        this.conciertosService = conciertosService;
    }

    @GetMapping
    public List<Conciertos> getAllConciertos() {
        return conciertosService.getAllConciertos();
    }

    @GetMapping("/{id}")
    public com.vans.backend.dto.ConciertoDTO getConciertoById(@PathVariable Integer id) {
        Conciertos concierto = conciertosService.getConciertoById(id);
        com.vans.backend.dto.ConciertoDTO dto = new com.vans.backend.dto.ConciertoDTO();
        dto.setConcierto_id(concierto.getConcierto_id());
        dto.setDireccion(concierto.getDireccion());
        dto.setFecha(concierto.getFecha());
        // BandaDTO
        com.vans.backend.dto.BandaDTO bandaDTO = new com.vans.backend.dto.BandaDTO();
        if (concierto.getBanda() != null) {
            bandaDTO.setBanda_id(concierto.getBanda().getBanda_id());
            bandaDTO.setNombre(concierto.getBanda().getNombre());
            bandaDTO.setGenero(concierto.getBanda().getGenero());
            bandaDTO.setPaisOrigen(concierto.getBanda().getPaisOrigen());
        }
        dto.setBanda(bandaDTO);
        // ViajesDTO
        java.util.List<com.vans.backend.dto.ViajeDTO> viajesDTO = new java.util.ArrayList<>();
        if (concierto.getViajes() != null) {
            for (com.vans.backend.entity.Viajes viaje : concierto.getViajes()) {
                com.vans.backend.dto.ViajeDTO viajeDTO = new com.vans.backend.dto.ViajeDTO();
                viajeDTO.setViaje_id(viaje.getViaje_id());
                viajeDTO.setOrigen(viaje.getOrigen());
                viajeDTO.setDestino(viaje.getDestino());
                viajeDTO.setPrecio(viaje.getPrecio() != null ? viaje.getPrecio().doubleValue() : null);
                viajeDTO.setAsientos_disponibles(viaje.getAsientos_disponibles());
                viajeDTO.setFechaSalida(viaje.getFechaSalida());
                viajeDTO.setFechaLlegada(viaje.getFechaLlegada());
                viajeDTO.setEstado(viaje.getEstado());
                // VehiculoDTO
                com.vans.backend.entity.Vehiculo vehiculo = viaje.getVehiculo();
                com.vans.backend.dto.VehiculoDTO vehiculoDTO = null;
                if (vehiculo != null) {
                    vehiculoDTO = new com.vans.backend.dto.VehiculoDTO(
                            vehiculo.getVehiculo_id(),
                            vehiculo.getModelo(),
                            vehiculo.getCapacidad(),
                            vehiculo.getPatente(),
                            vehiculo.getEstado());
                            if (vehiculo.getEmpresa() != null) {
                                viajeDTO.setEmpresa(vehiculo.getEmpresa().getNombre());
                            }
                }
                viajeDTO.setVehiculo(vehiculoDTO);
                viajesDTO.add(viajeDTO);
            }
        }
        dto.setViajes(viajesDTO);
        return dto;
    }

    @PostMapping
    public Conciertos createConcierto(@Valid @RequestBody Conciertos concierto) {
        return conciertosService.createConcierto(concierto);
    }

    @PutMapping("/{id}")
    public Conciertos updateConcierto(@PathVariable Integer id, @Valid @RequestBody Conciertos concierto) {
        return conciertosService.updateConcierto(id, concierto);
    }

    @DeleteMapping("/{id}")
    public void deleteConcierto(@PathVariable Integer id) {
        conciertosService.deleteConcierto(id);
    }
}
