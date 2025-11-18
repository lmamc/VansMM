
package com.vans.backend.service;

import com.vans.backend.repository.ViajesRepository;
import com.vans.backend.entity.Empresa;
import com.vans.backend.entity.Vehiculo;
import com.vans.backend.entity.Viajes;
import com.vans.backend.exception.ResourceNotFoundException;
import com.vans.backend.repository.EmpresaRepository;
import com.vans.backend.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private ViajesRepository viajesRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        Empresa empresa = empresaRepository.findById(vehiculo.getEmpresa().getEmpresaId())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));

        vehiculo.setEmpresa(empresa);
        return vehiculoRepository.save(vehiculo);
    }

    public Viajes saveViaje(Viajes viaje) {
    return viajesRepository.save(viaje);
    }

    public Viajes getViajeById(Integer id) {
        return viajesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Viaje no encontrado con id: " + id));
    }

    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getVehiculoById(Integer id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado con id: " + id));
    }

    public Vehiculo updateVehiculo(Integer id, Vehiculo vehiculoDetails) {
        Vehiculo vehiculo = getVehiculoById(id);
        vehiculo.setModelo(vehiculoDetails.getModelo());
        vehiculo.setCapacidad(vehiculoDetails.getCapacidad());
        vehiculo.setPatente(vehiculoDetails.getPatente());
        vehiculo.setEstado(vehiculoDetails.getEstado());
        return vehiculoRepository.save(vehiculo);
    }

    public void deleteVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }
}