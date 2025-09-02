package com.vans.backend;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.vans.backend.entity.Usuario;
import com.vans.backend.repository.UsuarioRepository;
import com.vans.backend.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    public UsuarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsuarios() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));

        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals(1, usuarios.get(0).getUsuario_id());
    }

    @Test
    public void testGetUsuarioById() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        when(usuarioRepository.findById(1)).thenReturn(java.util.Optional.of(usuario));

        Usuario found = usuarioService.getUsuarioById(1);
        assertNotNull(found);
        assertEquals(1, found.getUsuario_id());
    }
}