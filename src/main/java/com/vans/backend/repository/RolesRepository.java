package com.vans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vans.backend.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}