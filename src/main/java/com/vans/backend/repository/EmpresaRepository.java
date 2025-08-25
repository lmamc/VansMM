package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
