package com.vans.backend.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.*;



@Entity
@Table(name = "PAGOS")
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagos_seq_gen")
    @SequenceGenerator(name = "pagos_seq_gen", sequenceName = "pagos_seq", allocationSize = 1)
    @Column(name = "pago_id")
    private Integer pago_id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Integer tipo_pago;
    private String estado;
    private Integer monto;
    private LocalDateTime fecha_pago;


    public Pagos() {
    }

    // Getters
    public Integer getPago_id() {
        return pago_id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getTipo_pago() {
        return tipo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getMonto() {
        return monto;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }

    // Setters
    public void setPago_id(Integer pago_id) {
        this.pago_id = pago_id;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTipo_pago(Integer tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
}
