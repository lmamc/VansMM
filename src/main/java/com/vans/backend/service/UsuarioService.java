package com.vans.backend.service;

import com.vans.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Usuario;
import com.vans.backend.entity.Roles;
import com.vans.backend.repository.UsuarioRepository;
import com.vans.backend.repository.RolesRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public Usuario saveUser(Usuario usuario) {
        if (usuario.getRol() != null && usuario.getRol().getRolId() != null) {
            Roles rol = rolesRepository.findById(usuario.getRol().getRolId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
            usuario.setRol(rol);
        }
        // Encriptar la contraseña antes de guardar
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    public Usuario register(Usuario usuario) {
        return saveUser(usuario);
    }

    public void deleteUser(Integer id) {
        Usuario usuario = getUserById(id);
        usuarioRepository.delete(usuario);
    }
}