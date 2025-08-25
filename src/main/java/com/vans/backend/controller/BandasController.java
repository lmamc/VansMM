package com.vans.backend.controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Bandas;
import com.vans.backend.service.BandasService;

@RestController
@RequestMapping("/bandas")
public class BandasController {
    private final BandasService bandasService;

    // Constructor para inyectar el servicio
    public BandasController(BandasService bandasService) {
        this.bandasService = bandasService;
    }

    // GET /bandas
    @GetMapping
    public List<Bandas> getBandas() {
        return bandasService.getAllBandas();
    }

    // GET /bandas/{id}
    @GetMapping("/{id}")
    public Bandas getBanda(@PathVariable Integer id) {
        return bandasService.getBandaById(id);
    }

    // POST /bandas
    @PostMapping
    public Bandas createBanda(@RequestBody Bandas banda) {
        return bandasService.saveBanda(banda);
    }

    // DELETE /bandas/{id}
    @DeleteMapping("/{id}")
    public void deleteBanda(@PathVariable Integer id) {
        bandasService.deleteBanda(id);
    }
}