package com.vans.backend.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "RESERVAS")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservas_seq_gen")
    @SequenceGenerator(name = "reservas_seq_gen", sequenceName = "reservas_seq", allocationSize = 1)
    @Column(name = "reserva_id")
    private Integer reserva_id;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viajes viaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("usuario-reservas")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "asiento_id")
    @JsonBackReference("asiento-reservas")
    private Asientos asiento;

    @Column(name = "fecha_reserva")
    private LocalDateTime fecha_reserva;

    @Column(name = "estado")
    private String estado;

    public Reserva() {}

    public Integer getReserva_id() {
        return reserva_id;
    }

    public Viajes getViaje() {
        return viaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Asientos getAsiento() {
        return asiento;
    }

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setReserva_id(Integer reserva_id) {
        this.reserva_id = reserva_id;
    }

    public void setViaje(Viajes viaje) {
        this.viaje = viaje;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setAsiento(Asientos asiento) {
        this.asiento = asiento;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
