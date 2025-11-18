package com.vans.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Bandas;
import com.vans.backend.repository.BandasRepository;

@Service
public class BandasService {
    private final BandasRepository bandasRepository;

    public BandasService(BandasRepository bandasRepository) {
        this.bandasRepository = bandasRepository;
    }

    public List<Bandas> getAllBandas() {
        return bandasRepository.findAll();
    }

    public Bandas getBandaById(Integer id) {
        return bandasRepository.findById(id).orElse(null);
    }

    public Bandas saveBanda(Bandas banda) {
        return bandasRepository.save(banda);
    }

    public void deleteBanda(Integer id) {
        bandasRepository.deleteById(id);
    }
}