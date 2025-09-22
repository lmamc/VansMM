package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Empresa;
import com.vans.backend.repository.EmpresaRepository;
import com.vans.backend.service.EmpresaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaService empresaService;

    public EmpresaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmpresas() {
        Empresa empresa = new Empresa();
        empresa.setEmpresaId(1);
        when(empresaRepository.findAll()).thenReturn(Collections.singletonList(empresa));

        List<Empresa> empresas = empresaService.getAllEmpresas();
        assertEquals(1, empresas.size());
        assertEquals(1, empresas.get(0).getEmpresaId());
    }

    @Test
    public void testCreateEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombre("Test");
        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresa);

        Empresa saved = empresaService.createEmpresa(empresa);
        assertEquals("Test", saved.getNombre());
    }
}
