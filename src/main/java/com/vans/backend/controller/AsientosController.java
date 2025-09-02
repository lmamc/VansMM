package com.vans.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Asientos;
import com.vans.backend.service.AsientosService;


@RestController
@RequestMapping("/asientos")
public class AsientosController {
    private final AsientosService asientosService;


    public AsientosController(AsientosService asientosService){
        this.asientosService = asientosService;
    }


    @GetMapping
    public List<Asientos> getAsientos(){
        return asientosService.getAllAsientos();
    }


    @GetMapping("/{id}")
    public Asientos getAsiento(@PathVariable Integer id){
        return asientosService.getAsientoById(id);
    }


    @PostMapping
    public Asientos createAsiento(@RequestBody Asientos asiento){
        return asientosService.createAsiento(asiento);
    }


    @DeleteMapping("/{id}")
    public void deleteAsiento(@PathVariable Integer id){
        asientosService.deleteAsiento(id);
    }



}