package com.vans.backend.service;

import com.vans.backend.exception.ResourceNotFoundException;
//import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Asientos;
import com.vans.backend.repository.AsientosRepository;



@Service

public class AsientosService {
    private final AsientosRepository asientosRepository;

    public AsientosService(AsientosRepository asientosRepository) {
        this.asientosRepository = asientosRepository;
    }

    public List<Asientos> getAllAsientos() {
        return asientosRepository.findAll();
    }

    public Asientos getAsientoById(Integer id) {
        return asientosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asiento not found with id " + id));
    }

    public Asientos createAsiento(Asientos asiento) {
        return asientosRepository.save(asiento);
    }

    public Asientos updateAsiento(Integer id, Asientos asientoDetails) {
        Asientos asiento = getAsientoById(id);
        asiento.setNumeroAsiento(asientoDetails.getNumeroAsiento());
        asiento.setEstado(asientoDetails.getEstado());
        return asientosRepository.save(asiento);
    }

    public void deleteAsiento(Integer id) {
        Asientos asiento = getAsientoById(id);
        asientosRepository.delete(asiento);
    }


}
