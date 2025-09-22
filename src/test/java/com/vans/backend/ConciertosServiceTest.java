package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.vans.backend.entity.Conciertos;
import com.vans.backend.entity.Empresa;
import com.vans.backend.entity.Bandas;
import com.vans.backend.repository.BandasRepository;
import com.vans.backend.repository.ConciertosRepository;
import com.vans.backend.repository.EmpresaRepository;
import com.vans.backend.service.ConciertosService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.vans.backend.entity.Vehiculo;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class ConciertosServiceTest {

    @Mock
    private ConciertosRepository conciertosRepository;
    @Mock
    private EmpresaRepository empresaRepository;
    @Mock
    private BandasRepository bandasRepository;

    @InjectMocks
    private ConciertosService conciertosService;

    public ConciertosServiceTest() {
        MockitoAnnotations.openMocks(this);
        org.springframework.test.util.ReflectionTestUtils.setField(conciertosService, "empresaRepository", empresaRepository);
        org.springframework.test.util.ReflectionTestUtils.setField(conciertosService, "bandasRepository", bandasRepository);
    }

    @Test
    public void testGetAllConciertos() {
        Conciertos concierto = new Conciertos();
        concierto.setConcierto_id(1);
        when(conciertosRepository.findAll()).thenReturn(Collections.singletonList(concierto));

        List<Conciertos> conciertos = conciertosService.getAllConciertos();
        assertEquals(1, conciertos.size());
        assertEquals(1, conciertos.get(0).getConcierto_id());
    }

    @Test
    public void testCreateConcierto() {
        Conciertos concierto = new Conciertos();
        Empresa empresa = new Empresa();
        empresa.setEmpresaId(1);
        empresa.setNombre("EmpresaTest");
        concierto.setEmpresa(empresa);
        Bandas banda = new Bandas();
        banda.setBanda_id(2);
        banda.setNombre("BandaTest");
        concierto.setBanda(banda);
        when(empresaRepository.findById(1)).thenReturn(java.util.Optional.of(empresa));
        when(bandasRepository.findById(2)).thenReturn(java.util.Optional.of(banda));
        when(conciertosRepository.save(any(Conciertos.class))).thenReturn(concierto);

        Conciertos saved = conciertosService.createConcierto(concierto);
        assertEquals(1, saved.getEmpresa().getEmpresaId());
        assertEquals(2, saved.getBanda().getBanda_id());
    }
}
