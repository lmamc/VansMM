package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Vehiculo;
import com.vans.backend.repository.VehiculoRepository;
import com.vans.backend.service.VehiculoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class VehiculoServiceTest {

    @Mock
    private VehiculoRepository vehiculoRepository;

    @InjectMocks
    private VehiculoService vehiculoService;

    public VehiculoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllVehiculos() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculo_id(1);
        when(vehiculoRepository.findAll()).thenReturn(Collections.singletonList(vehiculo));

        List<Vehiculo> vehiculos = vehiculoService.getAllVehiculos();
        assertEquals(1, vehiculos.size());
        assertEquals(1, vehiculos.get(0).getVehiculo_id());
    }

    @Test
    public void testCreateVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setModelo("Test");
        when(vehiculoRepository.save(any(Vehiculo.class))).thenReturn(vehiculo);

        Vehiculo saved = vehiculoService.save(vehiculo);
        assertEquals("Test", saved.getModelo());
    }
}
