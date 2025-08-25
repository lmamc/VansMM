package com.vans.backend;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "PAGOS")
public class Pagos {
    @Id
    @Column(name = "pago_id")
    private Integer pago_id;
    private Integer empresa_id;
    private Integer reserva_id;
    private Integer usuario_id;
    private Integer tipo_pago;
    private String estado;
    private Integer monto;
    private LocalDateTime fecha_pago;


    public Pagos() {
    }

    public Integer getPago_id() {
        return pago_id;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public Integer getReserva_id() {
        return reserva_id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
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


    public void setPago_id(Integer pago_id) {
        this.pago_id = pago_id;
    }
    
    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setReserva_id(Integer reserva_id) {
        this.reserva_id = reserva_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
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
