package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Bandas;

public interface BandasRepository extends JpaRepository<Bandas, Integer> {
}
