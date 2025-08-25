package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
