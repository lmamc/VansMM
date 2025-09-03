package com.vans.backend.service;

import com.vans.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Pagos;
import com.vans.backend.entity.Empresa;
import com.vans.backend.entity.Reserva;
import com.vans.backend.entity.Usuario;
import com.vans.backend.repository.PagosRepository;
import com.vans.backend.repository.EmpresaRepository;
import com.vans.backend.repository.ReservaRepository;
import com.vans.backend.repository.UsuarioRepository;

@Service
public class PagosService {
    private final PagosRepository pagosRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public PagosService(PagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }

    public List<Pagos> getAllPagos() {
        return pagosRepository.findAll();
    }

    public Pagos getPagoById(Integer id) {
        return pagosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
    }

    public Pagos createPago(Pagos pago) {
        Empresa empresa = empresaRepository.findById(pago.getEmpresa().getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
        Reserva reserva = reservaRepository.findById(pago.getReserva().getReserva_id())
            .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
        Usuario usuario = usuarioRepository.findById(pago.getUsuario().getUsuario_id())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        pago.setEmpresa(empresa);
        pago.setReserva(reserva);
        pago.setUsuario(usuario);
        return pagosRepository.save(pago);
    }

    public Pagos updatePago(Integer id, Pagos pagoDetails) {
        Pagos pago = getPagoById(id);
        Empresa empresa = empresaRepository.findById(pagoDetails.getEmpresa().getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
        Reserva reserva = reservaRepository.findById(pagoDetails.getReserva().getReserva_id())
            .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
        Usuario usuario = usuarioRepository.findById(pagoDetails.getUsuario().getUsuario_id())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        pago.setEmpresa(empresa);
        pago.setReserva(reserva);
        pago.setUsuario(usuario);
        pago.setTipo_pago(pagoDetails.getTipo_pago());
        pago.setEstado(pagoDetails.getEstado());
        pago.setMonto(pagoDetails.getMonto());
        pago.setFecha_pago(pagoDetails.getFecha_pago());
        return pagosRepository.save(pago);
    }

    public void deletePago(Integer id) {
        Pagos pago = getPagoById(id);
        pagosRepository.delete(pago);
    }
}