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

import com.vans.backend.dto.ViajeDTO;
import com.vans.backend.dto.VehiculoDTO;
import java.util.stream.Collectors;

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


    public List<ViajeDTO> getAllViajesDTO() {
    return viajesRepository.findAll().stream().map(viaje -> {
        ViajeDTO dto = new ViajeDTO();
        dto.setViaje_id(viaje.getViaje_id());
        dto.setOrigen(viaje.getOrigen());
        dto.setDestino(viaje.getDestino());
        dto.setPrecio(viaje.getPrecio().doubleValue());
        dto.setAsientos_disponibles(viaje.getAsientos_disponibles());
        dto.setFechaSalida(viaje.getFechaSalida());
        dto.setFechaLlegada(viaje.getFechaLlegada());
        dto.setEstado(viaje.getEstado());
        // Mapea el vehículo si tienes VehiculoDTO
        Vehiculo vehiculo = viaje.getVehiculo();
        if (vehiculo != null) {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.setVehiculo_id(vehiculo.getVehiculo_id());
            vehiculoDTO.setPatente(vehiculo.getPatente());
            vehiculoDTO.setModelo(vehiculo.getModelo());
            vehiculoDTO.setTipo(vehiculo.getModelo()); // Ajusta si tienes tipo
            dto.setVehiculo(vehiculoDTO);
            // Aquí asignas el nombre de la empresa
            if (vehiculo.getEmpresa() != null) {
                dto.setEmpresa(vehiculo.getEmpresa().getNombre());
            }
        }
        return dto;
    }).collect(Collectors.toList());
}

    @Transactional
    public void deleteViaje(Integer id) {
        viajesRepository.deleteById(id);
    }
}
