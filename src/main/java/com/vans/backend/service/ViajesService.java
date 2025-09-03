package com.vans.backend.service;

import com.vans.backend.entity.Viajes;
import com.vans.backend.entity.Vehiculo;
import com.vans.backend.entity.Conciertos;
import com.vans.backend.repository.ViajesRepository;
import com.vans.backend.repository.VehiculoRepository;
import com.vans.backend.repository.ConciertosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ViajesService {

    @Autowired
    private ViajesRepository viajesRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ConciertosRepository conciertosRepository;

    @Transactional(readOnly = true)
    public List<Viajes> getAllViajes() {
        return viajesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Viajes> getViajeById(Integer id) {
        return viajesRepository.findById(id);
    }

    @Transactional
    public Viajes createViaje(Viajes viaje) {
        // Asegurarse de que el vehículo y el concierto existen
        Vehiculo vehiculo = vehiculoRepository.findById(viaje.getVehiculo().getVehiculo_id())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con id: " + viaje.getVehiculo().getVehiculo_id()));
        Conciertos concierto = conciertosRepository.findById(viaje.getConcierto().getConcierto_id())
                .orElseThrow(() -> new RuntimeException("Concierto no encontrado con id: " + viaje.getConcierto().getConcierto_id()));

        viaje.setVehiculo(vehiculo);
        viaje.setConcierto(concierto);

        return viajesRepository.save(viaje);
    }

    @Transactional
    public void deleteViaje(Integer id) {
        viajesRepository.deleteById(id);
    }
}
