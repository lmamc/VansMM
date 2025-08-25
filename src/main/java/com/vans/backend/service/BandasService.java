package com.vans.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Bandas;
import com.vans.backend.repository.BandasRepository;

@Service
public class BandasService {
    private final BandasRepository bandasRepository;

    // Constructor para inyectar el repositorio
    public BandasService(BandasRepository bandasRepository) {
        this.bandasRepository = bandasRepository;
    }

    // Obtener todas las bandas
    public List<Bandas> getAllBandas() {
        return bandasRepository.findAll();
    }

    // Obtener una banda por ID
    public Bandas getBandaById(Integer id) {
        return bandasRepository.findById(id).orElse(null);
    }

    // Guardar una banda
    public Bandas saveBanda(Bandas banda) {
        return bandasRepository.save(banda);
    }

    // Eliminar una banda por ID
    public void deleteBanda(Integer id) {
        bandasRepository.deleteById(id);
    }
}