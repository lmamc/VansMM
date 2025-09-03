package com.vans.backend.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "CONCIERTOS")
public class Conciertos {
    @Id
    @Column(name = "concierto_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conciertos_seq_gen")
    @SequenceGenerator(name = "conciertos_seq_gen", sequenceName = "conciertos_seq", allocationSize = 1)
    private Integer concierto_id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference("empresa-conciertos")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "banda_id")
    private Bandas banda;

    @OneToMany(mappedBy = "concierto")
    @JsonManagedReference("concierto-viajes")
    private List<Viajes> viajes;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public Conciertos() {}

    public Integer getConcierto_id() {
        return concierto_id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Bandas getBanda() {
        return banda;
    }

    public List<Viajes> getViajes() {
        return viajes;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setConcierto_id(Integer concierto_id) {
        this.concierto_id = concierto_id;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setBanda(Bandas banda) {
        this.banda = banda;
    }

    public void setViajes(List<Viajes> viajes) {
        this.viajes = viajes;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
