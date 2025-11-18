package com.vans.backend.controller;

import com.vans.backend.dto.VehiculoDTO;
import com.vans.backend.dto.ViajeDTO;
import com.vans.backend.entity.Vehiculo;
import com.vans.backend.entity.Viajes;
import com.vans.backend.service.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
@CrossOrigin(origins = "http://localhost:8100")
public class ViajesController {

    @Autowired
    private ViajesService viajesService;

    @PostMapping
    public ResponseEntity<Viajes> createViaje(@RequestBody Viajes viaje) {
        Viajes nuevoViaje = viajesService.createViaje(viaje);
        return ResponseEntity.ok(nuevoViaje);
    }

    @GetMapping
    public List<ViajeDTO> getAllViajes() {
        List<Viajes> viajes = viajesService.getAllViajes();
        return viajes.stream().map(this::toDTO).toList();
    }

    private ViajeDTO toDTO(Viajes viaje) {
        Vehiculo vehiculo = viaje.getVehiculo();

        System.out.println("Vehiculo: " + vehiculo);
        System.out.println("Empresa en Vehiculo: " + (vehiculo != null ? vehiculo.getEmpresa() : null));
        System.out.println("Empresa: " + (vehiculo != null ? vehiculo.getEmpresa() : null));
        System.out.println("Nombre empresa: "
                + (vehiculo != null && vehiculo.getEmpresa() != null ? vehiculo.getEmpresa().getNombre() : null));

        VehiculoDTO vehiculoDTO = null;
        if (vehiculo != null) {
            vehiculoDTO = new VehiculoDTO(
                    vehiculo.getVehiculo_id(),
                    vehiculo.getModelo(),
                    vehiculo.getCapacidad(),
                    vehiculo.getPatente(),
                    vehiculo.getEstado());
        }
        ViajeDTO dto = new ViajeDTO();
        dto.setViaje_id(viaje.getViaje_id());
        dto.setOrigen(viaje.getOrigen());
        dto.setDestino(viaje.getDestino());
        dto.setPrecio(viaje.getPrecio() != null ? viaje.getPrecio().doubleValue() : null);
        dto.setAsientos_disponibles(viaje.getAsientos_disponibles());
        dto.setFechaSalida(viaje.getFechaSalida());
        dto.setFechaLlegada(viaje.getFechaLlegada());
        if (vehiculo != null && vehiculo.getEmpresa() != null) {
            dto.setEmpresa(vehiculo.getEmpresa().getNombre());
        }
        dto.setEstado(viaje.getEstado());
        dto.setVehiculo(vehiculoDTO);
        return dto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viajes> getViajeById(@PathVariable Integer id) {
        return viajesService.getViajeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/asientos")
    public List<com.vans.backend.dto.AsientoDTO> getAsientosByViaje(@PathVariable Integer id) {
        Viajes viaje = viajesService.getViajeById(id).orElse(null);
        if (viaje == null || viaje.getVehiculo() == null) {
            return java.util.Collections.emptyList();
        }
        List<com.vans.backend.entity.Asientos> asientos = viaje.getVehiculo().getAsientos();
        if (asientos == null) {
            return java.util.Collections.emptyList();
        }
        asientos = asientos.stream()
                .filter(a -> a.getViaje() != null && a.getViaje().getViaje_id().equals(viaje.getViaje_id()))
                .toList();
        return asientos.stream().map(a -> {
            com.vans.backend.dto.AsientoDTO dto = new com.vans.backend.dto.AsientoDTO();
            dto.setAsiento_id(a.getAsientoId());
            dto.setNumero(a.getNumeroAsiento());
            dto.setEstado(a.getEstado());
            return dto;
        }).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaje(@PathVariable Integer id) {
        viajesService.deleteViaje(id);
        return ResponseEntity.noContent().build();
    }
}