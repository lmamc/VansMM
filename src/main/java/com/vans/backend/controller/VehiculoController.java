package com.vans.backend.controller;

import com.vans.backend.entity.Vehiculo;
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

    @GetMapping("/{id}")
    public Vehiculo getVehiculoById(@PathVariable Integer id) {
        return vehiculoService.getVehiculoById(id);
    }

    @PutMapping("/{id}")
    public Vehiculo updateVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculoDetails) {
        return vehiculoService.updateVehiculo(id, vehiculoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable Integer id) {
        vehiculoService.deleteVehiculo(id);
    }
}