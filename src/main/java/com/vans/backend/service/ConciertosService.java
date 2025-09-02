package com.vans.backend.service;

import org.springframework.stereotype.Service;

import com.vans.backend.exception.ResourceNotFoundException;
import java.util.List;
import com.vans.backend.entity.Conciertos;
import com.vans.backend.repository.ConciertosRepository;

@Service
public class ConciertosService {
    private final ConciertosRepository conciertosRepository;

    public ConciertosService(ConciertosRepository conciertosRepository) {
        this.conciertosRepository = conciertosRepository;
    }

    public List<Conciertos> getAllConciertos() {
        return conciertosRepository.findAll();
    }

    public Conciertos getConciertoById(Integer id) {
        return conciertosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Concierto no encontrado"));
    }

    public Conciertos createConcierto(Conciertos concierto) {
        return conciertosRepository.save(concierto);
    }

    public Conciertos updateConcierto(Integer id, Conciertos conciertoDetails) {
        Conciertos concierto = getConciertoById(id);
        concierto.setEmpresa_id(conciertoDetails.getEmpresa_id());
        concierto.setBanda_id(conciertoDetails.getBanda_id());
        concierto.setDireccion(conciertoDetails.getDireccion());
        concierto.setFecha(conciertoDetails.getFecha());
        return conciertosRepository.save(concierto);
    }

    public void deleteConcierto(Integer id) {
        Conciertos concierto = getConciertoById(id);
        conciertosRepository.delete(concierto);
    }
}