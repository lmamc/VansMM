package com.vans.backend;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name = "ROLES")
public class Roles {
    @Id
    @Column(name = "role_id")
    private Integer role_id;
    private String nombre;


    public Roles(){}

    public Integer getRoleId() {
        return role_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRoleId(Integer role_id) {
        this.role_id = role_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
