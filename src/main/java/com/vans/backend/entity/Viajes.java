package com.vans.backend.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "VIAJES")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viajes_seq_gen")
    @SequenceGenerator(name = "viajes_seq_gen", sequenceName = "viajes_seq", allocationSize = 1)
    @Column(name = "viaje_id")
    private Integer viaje_id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    @JsonBackReference("vehiculo-viajes")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "concierto_id")
    @JsonBackReference("concierto-viajes")
    private Conciertos concierto;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "asientos_disponibles")
    private Integer asientos_disponibles;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_llegada")
    private LocalDateTime fechaLlegada;

    @Column(name = "estado")
    private String estado;


    public Viajes() {}

    public Integer getViaje_id() {
        return viaje_id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Conciertos getConcierto() {
        return concierto;
    }

    public Integer getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public String getEstado() {
        return estado;
    }

    public void setViaje_id(Integer viaje_id) {
        this.viaje_id = viaje_id;
    }

    public void setAsientos_disponibles(Integer asientos_disponibles){
        this.asientos_disponibles = asientos_disponibles;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setConcierto(Conciertos concierto) {
        this.concierto = concierto;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
