package com.vans.backend.controller;

import com.vans.backend.entity.Reserva;
import com.vans.backend.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vans.backend.dto.ReservaDTO;
import com.vans.backend.entity.Usuario;
import com.vans.backend.entity.Viajes;
import com.vans.backend.entity.Asientos;

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
    public Reserva createReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setUsuario(new Usuario());
        reserva.getUsuario().setUsuario_id(reservaDTO.getUsuario_id());
        reserva.setViaje(new Viajes());
        reserva.getViaje().setViaje_id(reservaDTO.getViaje_id());
        reserva.setAsiento(new Asientos());
        reserva.getAsiento().setAsientoId(reservaDTO.getAsiento_id());
        reserva.setFecha_reserva(reservaDTO.getFecha_reserva());
        reserva.setEstado(reservaDTO.getEstado());
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