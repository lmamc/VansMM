package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Conciertos;
import com.vans.backend.entity.Vehiculo;

import com.vans.backend.entity.Viajes;
import com.vans.backend.repository.ConciertosRepository;
import com.vans.backend.repository.VehiculoRepository;
import com.vans.backend.repository.ViajesRepository;
import com.vans.backend.service.ViajesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class ViajesServiceTest {

    @Mock
    private ViajesRepository viajesRepository;
    @Mock
    private VehiculoRepository vehiculoRepository;
    @Mock
    private ConciertosRepository conciertosRepository;
    @Mock
    private com.vans.backend.repository.AsientosRepository asientosRepository;

    @InjectMocks
    private ViajesService viajesService;

    public ViajesServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllViajes() {
        Viajes viaje = new Viajes();
        viaje.setViaje_id(1);
        when(viajesRepository.findAll()).thenReturn(Collections.singletonList(viaje));

        List<Viajes> viajes = viajesService.getAllViajes();
        assertEquals(1, viajes.size());
        assertEquals(1, viajes.get(0).getViaje_id());
    }

    @Test
    public void testCreateViaje() {
        Viajes viaje = new Viajes();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculo_id(1);
        vehiculo.setCapacidad(10); 
        viaje.setVehiculo(vehiculo);
        Conciertos concierto = new Conciertos();
        concierto.setConcierto_id(2);
        viaje.setConcierto(concierto);
        when(vehiculoRepository.findById(1)).thenReturn(java.util.Optional.of(vehiculo));
        when(conciertosRepository.findById(2)).thenReturn(java.util.Optional.of(concierto));
        when(viajesRepository.save(any(Viajes.class))).thenReturn(viaje);
        when(asientosRepository.save(any(com.vans.backend.entity.Asientos.class))).thenReturn(new com.vans.backend.entity.Asientos());

        Viajes saved = viajesService.createViaje(viaje);
        assertEquals(1, saved.getVehiculo().getVehiculo_id());
        assertEquals(2, saved.getConcierto().getConcierto_id());
        verify(asientosRepository, times(10)).save(any(com.vans.backend.entity.Asientos.class));
    }
}
