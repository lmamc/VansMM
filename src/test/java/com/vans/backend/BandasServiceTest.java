package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Bandas;
import com.vans.backend.repository.BandasRepository;
import com.vans.backend.service.BandasService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class BandasServiceTest {

    @Mock
    private BandasRepository bandasRepository;

    @InjectMocks
    private BandasService bandasService;

    public BandasServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBandas() {
        Bandas banda = new Bandas();
        banda.setBanda_id(1);
        when(bandasRepository.findAll()).thenReturn(Collections.singletonList(banda));

        List<Bandas> bandas = bandasService.getAllBandas();
        assertEquals(1, bandas.size());
        assertEquals(1, bandas.get(0).getBanda_id());
    }

    @Test
    public void testSaveBanda() {
        Bandas banda = new Bandas();
        banda.setNombre("Test");
        when(bandasRepository.save(any(Bandas.class))).thenReturn(banda);

        Bandas saved = bandasService.saveBanda(banda);
        assertEquals("Test", saved.getNombre());
    }
}
