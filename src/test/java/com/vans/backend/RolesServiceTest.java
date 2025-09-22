package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Roles;
import com.vans.backend.repository.RolesRepository;
import com.vans.backend.service.RolesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class RolesServiceTest {

    @Mock
    private RolesRepository rolesRepository;

    @InjectMocks
    private RolesService rolesService;

    public RolesServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRoles() {
        Roles rol = new Roles();
        rol.setRolId(1);
        when(rolesRepository.findAll()).thenReturn(Collections.singletonList(rol));

        List<Roles> roles = rolesService.getAllRoles();
        assertEquals(1, roles.size());
        assertEquals(1, roles.get(0).getRolId());
    }

    @Test
    public void testSaveRol() {
        Roles rol = new Roles();
        rol.setNombre("ADMIN");
        when(rolesRepository.save(any(Roles.class))).thenReturn(rol);

        Roles saved = rolesService.saveRol(rol);
        assertEquals("ADMIN", saved.getNombre());
    }
}
