package com.vans.backend.service;

import com.vans.backend.exception.ResourceNotFoundException;
//import java.util.Optional; 
import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Usuario;
import com.vans.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    // Constructor para inyectar el repositorio
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Usuario getUserById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    // Obtener un usuario por nombre de usuario
    public Usuario getUserByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public Usuario login(String username, String contraseña) {
        Usuario usuario = usuarioRepository.findByUsername(username).orElse(null);
        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            return usuario;
        }
        return null;
    }

    // Guardar un usuario
    public Usuario saveUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public void deleteUser(Integer id) {
        usuarioRepository.deleteById(id);
    }
}