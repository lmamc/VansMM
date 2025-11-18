package com.vans.backend.controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Bandas;
import com.vans.backend.service.BandasService;

@RestController
@RequestMapping("/bandas")
public class BandasController {
    private final BandasService bandasService;

    public BandasController(BandasService bandasService) {
        this.bandasService = bandasService;
    }

    @GetMapping
    public List<Bandas> getBandas() {
        return bandasService.getAllBandas();
    }

    @GetMapping("/{id}")
    public Bandas getBanda(@PathVariable Integer id) {
        return bandasService.getBandaById(id);
    }

    @PostMapping
    public Bandas createBanda(@RequestBody Bandas banda) {
        return bandasService.saveBanda(banda);
    }

    @DeleteMapping("/{id}")
    public void deleteBanda(@PathVariable Integer id) {
        bandasService.deleteBanda(id);
    }
}