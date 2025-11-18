package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Viajes;




public interface ViajesRepository extends JpaRepository<Viajes, Integer> {
}
