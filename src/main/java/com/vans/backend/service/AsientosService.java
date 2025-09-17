package com.vans.backend.service;

import com.vans.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Asientos;
import com.vans.backend.entity.Vehiculo;
import com.vans.backend.entity.Viajes;
import com.vans.backend.repository.AsientosRepository;
import com.vans.backend.repository.VehiculoRepository;
import com.vans.backend.repository.ViajesRepository;

@Service
public class AsientosService {
    private final AsientosRepository asientosRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private ViajesRepository viajesRepository;

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
        Vehiculo vehiculo = vehiculoRepository.findById(asiento.getVehiculo().getVehiculo_id())
            .orElseThrow(() -> new ResourceNotFoundException("Vehiculo no encontrado"));
        Viajes viaje = viajesRepository.findById(asiento.getViaje().getViaje_id())
            .orElseThrow(() -> new ResourceNotFoundException("Viaje no encontrado"));

        asiento.setVehiculo(vehiculo);
        asiento.setViaje(viaje);
        return asientosRepository.save(asiento);
    }

    public Asientos updateAsiento(Integer id, Asientos asientoDetails) {
        Asientos asiento = getAsientoById(id);
        Vehiculo vehiculo = vehiculoRepository.findById(asientoDetails.getVehiculo().getVehiculo_id())
            .orElseThrow(() -> new ResourceNotFoundException("Vehiculo no encontrado"));
        Viajes viaje = viajesRepository.findById(asientoDetails.getViaje().getViaje_id())
            .orElseThrow(() -> new ResourceNotFoundException("Viaje no encontrado"));

        asiento.setVehiculo(vehiculo);
        asiento.setViaje(viaje);
        asiento.setNumeroAsiento(asientoDetails.getNumeroAsiento());
        asiento.setEstado(asientoDetails.getEstado());
        return asientosRepository.save(asiento);
    }


    public Viajes getViajeById(Integer id) {
    return viajesRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Viaje no encontrado con id: " + id));
}

    public void deleteAsiento(Integer id) {
        Asientos asiento = getAsientoById(id);
        asientosRepository.delete(asiento);
    }
}