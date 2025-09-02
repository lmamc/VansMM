package com.vans.backend.service;

import org.springframework.stereotype.Service; 
import com.vans.backend.exception.ResourceNotFoundException;
import java.util.List;
import com.vans.backend.entity.Pagos;
import com.vans.backend.repository.PagosRepository;


@Service
public class PagosService {
    private final PagosRepository pagosRepository;

    public PagosService(PagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }

    public List<Pagos> getAllPagos(){
        return pagosRepository.findAll();
    }


    public Pagos getPagosById(Integer id){
        return pagosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago no encnontrado"));
    }

    public Pagos savePago(Pagos pago){
        return pagosRepository.save(pago);
    }

    public Pagos createPago(Pagos pago){
        return pagosRepository.save(pago);
    }

    public Pagos updatePago(Integer id, Pagos pagoDetails){
        Pagos existingPago = pagosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
            existingPago.setMonto(pagoDetails.getMonto());
            existingPago.setFecha_pago(pagoDetails.getFecha_pago());
            return pagosRepository.save(existingPago);
    }

    public void deletePago(Integer id){
        Pagos existingPago = pagosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        pagosRepository.delete(existingPago);
    }

}
