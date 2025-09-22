package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.vans.backend.entity.Vehiculo;
import com.vans.backend.entity.Viajes;
import com.vans.backend.entity.Asientos;
import com.vans.backend.repository.AsientosRepository;
import com.vans.backend.repository.VehiculoRepository;
import com.vans.backend.repository.ViajesRepository;
import com.vans.backend.service.AsientosService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class AsientosServiceTest {

    @Mock
    private AsientosRepository asientosRepository;
    @Mock
    private VehiculoRepository vehiculoRepository;
    @Mock
    private ViajesRepository viajesRepository;

    @InjectMocks
    private AsientosService asientosService;

    public AsientosServiceTest() {
        MockitoAnnotations.openMocks(this);
        org.springframework.test.util.ReflectionTestUtils.setField(asientosService, "vehiculoRepository", vehiculoRepository);
        org.springframework.test.util.ReflectionTestUtils.setField(asientosService, "viajesRepository", viajesRepository);
    }

    @Test
    public void testGetAllAsientos() {
        Asientos asiento = new Asientos();
        asiento.setAsientoId(1);
        when(asientosRepository.findAll()).thenReturn(Collections.singletonList(asiento));

        List<Asientos> asientos = asientosService.getAllAsientos();
        assertEquals(1, asientos.size());
        assertEquals(1, asientos.get(0).getAsientoId());
    }

    @Test
    public void testCreateAsiento() {
        Asientos asiento = new Asientos();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculo_id(1);
        asiento.setVehiculo(vehiculo);
        Viajes viaje = new Viajes();
        viaje.setViaje_id(2);
        asiento.setViaje(viaje);
        asiento.setNumeroAsiento("1");
        when(vehiculoRepository.findById(1)).thenReturn(java.util.Optional.of(vehiculo));
        when(viajesRepository.findById(2)).thenReturn(java.util.Optional.of(viaje));
        when(asientosRepository.save(any(Asientos.class))).thenReturn(asiento);

        Asientos saved = asientosService.createAsiento(asiento);
        assertEquals(1, saved.getVehiculo().getVehiculo_id());
        assertEquals(2, saved.getViaje().getViaje_id());
    }
}
