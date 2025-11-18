package com.vans.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vans.backend.exception.ResourceNotFoundException;
import java.util.List;
import com.vans.backend.entity.Conciertos;
import com.vans.backend.entity.Empresa;
import com.vans.backend.entity.Bandas;
import com.vans.backend.repository.ConciertosRepository;
import com.vans.backend.repository.EmpresaRepository;
import com.vans.backend.repository.BandasRepository;

@Service
public class ConciertosService {
    private final ConciertosRepository conciertosRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private BandasRepository bandasRepository;

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
        Empresa empresa = empresaRepository.findById(concierto.getEmpresa().getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
        Bandas banda = bandasRepository.findById(concierto.getBanda().getBanda_id())
            .orElseThrow(() -> new ResourceNotFoundException("Banda no encontrada"));

        concierto.setEmpresa(empresa);
        concierto.setBanda(banda);
        return conciertosRepository.save(concierto);
    }

    public Conciertos updateConcierto(Integer id, Conciertos conciertoDetails) {
        Conciertos concierto = getConciertoById(id);
        Empresa empresa = empresaRepository.findById(conciertoDetails.getEmpresa().getEmpresaId())
            .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
        Bandas banda = bandasRepository.findById(conciertoDetails.getBanda().getBanda_id())
            .orElseThrow(() -> new ResourceNotFoundException("Banda no encontrada"));

        concierto.setEmpresa(empresa);
        concierto.setBanda(banda);
        concierto.setDireccion(conciertoDetails.getDireccion());
        concierto.setFecha(conciertoDetails.getFecha());
        return conciertosRepository.save(concierto);
    }

    public void deleteConcierto(Integer id) {
        Conciertos concierto = getConciertoById(id);
        conciertosRepository.delete(concierto);
    }
}