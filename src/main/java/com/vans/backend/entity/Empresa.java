package com.vans.backend.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "EMPRESA")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresas_seq_gen")
    @SequenceGenerator(name = "empresas_seq_gen", sequenceName = "empresas_seq", allocationSize = 1)
    @Column(name = "empresa_id")
    @JsonProperty("empresa_id")
    private Integer empresa_id;

    @OneToMany(mappedBy = "empresa")
    @JsonManagedReference("empresa-vehiculos")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "empresa")
    @JsonManagedReference("empresa-conciertos")
    private List<Conciertos> conciertos;

    private String nombre;
    private String direccion;
    private String horario;
    private String telefono;

    public Empresa() {}

    public Integer getEmpresaId() {
        return empresa_id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Conciertos> getConciertos() {
        return conciertos;
    }

    public String getHorario() {
        return horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmpresaId(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setConciertos(List<Conciertos> conciertos) {
        this.conciertos = conciertos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}


