package com.vans.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.vans.backend.entity.Empresa;
import com.vans.backend.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Integer id) {
        empresaRepository.deleteById(id);
    }

    public void updateEmpresa(Integer id, Empresa empresaDetails) {
        Empresa empresa = getEmpresaById(id);
        if (empresa != null) {
            empresa.setNombre(empresaDetails.getNombre());
            empresa.setDireccion(empresaDetails.getDireccion());
            empresa.setTelefono(empresaDetails.getTelefono());
            empresaRepository.save(empresa);
        }
    }
}
