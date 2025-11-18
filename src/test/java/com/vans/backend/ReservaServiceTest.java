package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Reserva;
import com.vans.backend.entity.Usuario;
import com.vans.backend.entity.Viajes;
import com.vans.backend.entity.Asientos;
import com.vans.backend.repository.ReservaRepository;
import com.vans.backend.repository.UsuarioRepository;
import com.vans.backend.repository.ViajesRepository;
import com.vans.backend.repository.AsientosRepository;
import com.vans.backend.service.ReservaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private ViajesRepository viajesRepository;
    @Mock
    private AsientosRepository asientosRepository;

    @InjectMocks
    private ReservaService reservaService;

    public ReservaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateReserva() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);

        Viajes viaje = new Viajes();
        viaje.setViaje_id(2);

        Asientos asiento = new Asientos();
        asiento.setAsientoId(3);

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setViaje(viaje);
        reserva.setAsiento(asiento);
        reserva.setFecha_reserva(LocalDateTime.now());
        reserva.setEstado("Reservado");

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(viajesRepository.findById(2)).thenReturn(Optional.of(viaje));
        when(asientosRepository.findById(3)).thenReturn(Optional.of(asiento));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        Reserva saved = reservaService.createReserva(reserva);

        assertNotNull(saved);
        assertEquals("Reservado", saved.getEstado());
        assertEquals(1, saved.getUsuario().getUsuario_id());
        assertEquals(2, saved.getViaje().getViaje_id());
        assertEquals(3, saved.getAsiento().getAsientoId());
    }
}