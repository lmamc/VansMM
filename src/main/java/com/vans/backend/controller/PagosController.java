package com.vans.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Pagos;
import com.vans.backend.service.PagosService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagos")
public class PagosController {
    private final PagosService pagosService;

    public PagosController(PagosService pagosService) {
        this.pagosService = pagosService;
    }

    @GetMapping
    public List<Pagos> getAllPagos() {
        return pagosService.getAllPagos();
    }

    @GetMapping("/{id}")
    public Pagos getPagoById(@PathVariable Integer id) {
        return pagosService.getPagosById(id);
    }

    @PostMapping
    public Pagos createPago(@Valid @RequestBody Pagos pagos) {
        return pagosService.createPago(pagos);
    }

    @PutMapping("/{id}")
    public Pagos updatePago(@PathVariable Integer id, @Valid @RequestBody Pagos pagos) {
        return pagosService.updatePago(id, pagos);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Integer id) {
        pagosService.deletePago(id);
    }
}