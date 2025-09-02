package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Pagos;

public interface PagosRepository extends JpaRepository<Pagos, Integer> {
}