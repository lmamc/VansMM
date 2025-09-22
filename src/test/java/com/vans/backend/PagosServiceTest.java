package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Pagos;
import com.vans.backend.repository.PagosRepository;
import com.vans.backend.service.PagosService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class PagosServiceTest {

    @Mock
    private PagosRepository pagosRepository;

    @InjectMocks
    private PagosService pagosService;

    public PagosServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPagos() {
        Pagos pago = new Pagos();
        pago.setPago_id(1);
        when(pagosRepository.findAll()).thenReturn(Collections.singletonList(pago));

        List<Pagos> pagos = pagosService.getAllPagos();
        assertEquals(1, pagos.size());
        assertEquals(1, pagos.get(0).getPago_id());
    }

}
