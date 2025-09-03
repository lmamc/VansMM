package com.vans.backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;



@Entity
@Table(name = "ROLES")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq_gen")
    @SequenceGenerator(name = "roles_seq_gen", sequenceName = "roles_seq", allocationSize = 1)
    @Column(name = "rol_id")
    private Integer rol_id;
    private String nombre;


    public Roles(){}

    public Integer getRolId() {
        return rol_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRolId(Integer rol_id) {
        this.rol_id = rol_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
