package com.vans.backend.service;

import com.vans.backend.entity.Asientos;
import com.vans.backend.entity.Reserva;
import com.vans.backend.entity.Usuario;
import com.vans.backend.entity.Viajes;
import com.vans.backend.exception.ResourceNotFoundException;
import com.vans.backend.repository.AsientosRepository;
import com.vans.backend.repository.ReservaRepository;
import com.vans.backend.repository.UsuarioRepository;
import com.vans.backend.repository.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

        @Autowired
        private ReservaRepository reservaRepository;
        @Autowired
        private ViajesRepository viajesRepository;
        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private AsientosRepository asientosRepository;

        public List<Reserva> getAllReservas() {
                return reservaRepository.findAll();
        }

        public Reserva getReservaById(Integer id) {
                return reservaRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Reserva no encontrada con id: " + id));
        }

        public Reserva createReserva(Reserva reserva) {
                Viajes viaje = viajesRepository.findById(reserva.getViaje().getViaje_id())
                                .orElseThrow(() -> new ResourceNotFoundException("Viaje no encontrado"));
                Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getUsuario_id())
                                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
                Asientos asiento = asientosRepository.findById(reserva.getAsiento().getAsientoId())
                                .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado"));

                reserva.setViaje(viaje);
                reserva.setUsuario(usuario);
                reserva.setAsiento(asiento);

                Reserva nuevaReserva = reservaRepository.save(reserva);
                asiento.setEstado("ocupado");
                asientosRepository.save(asiento);

                return nuevaReserva;
        }

        public Reserva updateReserva(Integer id, Reserva reservaDetails) {
                Reserva reserva = getReservaById(id);

                Viajes viaje = viajesRepository.findById(reservaDetails.getViaje().getViaje_id())
                                .orElseThrow(() -> new ResourceNotFoundException("Viaje no encontrado"));
                Usuario usuario = usuarioRepository.findById(reservaDetails.getUsuario().getUsuario_id())
                                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
                Asientos asiento = asientosRepository.findById(reservaDetails.getAsiento().getAsientoId())
                                .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado"));

                reserva.setViaje(viaje);
                reserva.setUsuario(usuario);
                reserva.setAsiento(asiento);
                reserva.setFecha_reserva(reservaDetails.getFecha_reserva());
                reserva.setEstado(reservaDetails.getEstado());

                return reservaRepository.save(reserva);
        }

        public void deleteReserva(Integer id) {
                Reserva reserva = getReservaById(id);
                reservaRepository.delete(reserva);
        }
}