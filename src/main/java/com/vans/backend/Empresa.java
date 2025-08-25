package com.vans.backend;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "EMPRESAS")
public class Empresa {
    @Id
    @Column(name = "empresa_id")
    private Integer empresa_id;
    private String nombre;
    private String direccion;
    private Integer telefono;

    public Empresa() {}


    public Integer getEmpresaId() {
        return empresa_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setEmpresaId(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

}


