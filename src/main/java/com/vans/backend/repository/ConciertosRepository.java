package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Conciertos;

public interface ConciertosRepository extends JpaRepository<Conciertos, Integer> {
}