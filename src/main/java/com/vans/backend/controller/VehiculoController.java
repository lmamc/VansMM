
package com.vans.backend.controller;

import com.vans.backend.entity.Asientos;
import com.vans.backend.entity.Vehiculo;
import com.vans.backend.entity.Viajes;
import com.vans.backend.service.VehiculoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.createVehiculo(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }

    @GetMapping("/{id}/asientos")
    public List<com.vans.backend.dto.AsientoDTO> getAsientosByVehiculo(@PathVariable Integer id) {
        Vehiculo vehiculo = vehiculoService.getVehiculoById(id);
        List<com.vans.backend.entity.Asientos> asientos = vehiculo.getAsientos();
        if (asientos == null) {
            return java.util.Collections.emptyList();
        }
        return asientos.stream().map(a -> {
            com.vans.backend.dto.AsientoDTO dto = new com.vans.backend.dto.AsientoDTO();
            dto.setAsiento_id(a.getAsientoId());
            dto.setNumero(a.getNumeroAsiento());
            dto.setEstado(a.getEstado());
            return dto;
        }).toList();
    }

    @GetMapping("/{id}")
    public Vehiculo getVehiculoById(@PathVariable Integer id) {
        return vehiculoService.getVehiculoById(id);
    }

    @PutMapping("/{id}")
    public Vehiculo updateVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculoDetails) {
        return vehiculoService.updateVehiculo(id, vehiculoDetails);
    }

    @PutMapping("/{vehiculoId}/vincular-viaje/{viajeId}")
    public Vehiculo vincularVehiculoAViaje(@PathVariable Integer vehiculoId, @PathVariable Integer viajeId) {
        Vehiculo vehiculo = vehiculoService.getVehiculoById(vehiculoId);
        Viajes viaje = vehiculoService.getViajeById(viajeId);

        // Asocia el vehículo al viaje
        viaje.setVehiculo(vehiculo);
        vehiculoService.saveViaje(viaje);

        // Asocia los asientos del vehículo al viaje y guarda cada uno
        for (Asientos asiento : vehiculo.getAsientos()) {
            asiento.setViaje(viaje);
            vehiculoService.saveAsiento(asiento); // Este método debe guardar el asiento
        }

        return vehiculo;
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable Integer id) {
        vehiculoService.deleteVehiculo(id);
    }
}