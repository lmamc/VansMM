package com.vans.backend.controller;

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
    public List<Viajes> getAllViajes() {
        return viajesService.getAllViajes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viajes> getViajeById(@PathVariable Integer id) {
        return viajesService.getViajeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaje(@PathVariable Integer id) {
        viajesService.deleteViaje(id);
        return ResponseEntity.noContent().build();
    }
}