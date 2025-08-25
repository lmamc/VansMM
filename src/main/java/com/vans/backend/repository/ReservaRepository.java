package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
