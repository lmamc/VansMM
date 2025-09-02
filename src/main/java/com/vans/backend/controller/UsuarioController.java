package com.vans.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Usuario;
import com.vans.backend.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Integer id) {
        return usuarioService.getUserById(id);
    }

    @PostMapping
    public Usuario createUser(@Valid @RequestBody Usuario usuario) {
        return usuarioService.saveUser(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUser(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setUsuario_id(id);
        return usuarioService.saveUser(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usuarioService.deleteUser(id);
    }
}