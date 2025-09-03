package com.vans.backend.service;

import com.vans.backend.exception.ResourceNotFoundException;
//import java.util.Optional; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Usuario;
import com.vans.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        Usuario usuario = getUserByUsername(username);
        if (passwordEncoder.matches(contraseña, usuario.getContraseña())) {
            return usuario;
        }
        return null;
    }

    public Usuario register(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
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