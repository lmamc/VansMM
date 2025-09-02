package com.vans.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Empresa;
import com.vans.backend.service.EmpresaService;



@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;
    
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> getEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresaById(@PathVariable Integer id) {
    return empresaService.getEmpresaById(id);
}

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.createEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable Integer id) {
        empresaService.deleteEmpresa(id);
    }

    @PutMapping("/{id}")
    public void updateEmpresa(@PathVariable Integer id, @RequestBody Empresa empresa) {
        empresaService.updateEmpresa(id, empresa);
    }

}
