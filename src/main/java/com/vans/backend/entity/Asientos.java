package com.vans.backend.entity;
import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ASIENTOS")
public class Asientos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asientos_seq_gen")
    @SequenceGenerator(name = "asientos_seq_gen", sequenceName = "asientos_seq", allocationSize = 1)
    @Column(name = "asiento_id")
    private Integer asiento_id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    @JsonBackReference("vehiculo-asientos")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viajes viaje;

    @OneToMany(mappedBy = "asiento")
    @JsonManagedReference("asiento-reservas")
    private List<Reserva> reservas;

    @Column(name = "numero_asiento")
    private String numeroAsiento;

    @Column(name = "estado")
    private String estado;

    public Asientos() {}

    public Integer getAsientoId() {
        return asiento_id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Viajes getViaje() {
        return viaje;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String getNumeroAsiento() { 
    return numeroAsiento;
}

    public String getEstado() {
        return estado;
    }

    public void setAsientoId(Integer asiento_id) {
        this.asiento_id = asiento_id;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setViaje(Viajes viaje) {
        this.viaje = viaje;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setNumeroAsiento(String numeroAsiento) { 
    this.numeroAsiento = numeroAsiento;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
}
