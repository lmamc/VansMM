package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Asientos;

public interface AsientosRepository extends JpaRepository<Asientos, Integer> {
}
