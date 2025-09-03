package com.vans.backend.controller;

import com.vans.backend.entity.Reserva;
import com.vans.backend.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public Reserva getReservaById(@PathVariable Integer id) {
        return reservaService.getReservaById(id);
    }

    @PostMapping
    public Reserva createReserva(@Valid @RequestBody Reserva reserva) {
        return reservaService.createReserva(reserva);
    }

    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Integer id, @Valid @RequestBody Reserva reservaDetails) {
        return reservaService.updateReserva(id, reservaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Integer id) {
        reservaService.deleteReserva(id);
    }
}