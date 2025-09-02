package com.vans.backend.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Conciertos;
import com.vans.backend.service.ConciertosService;


@RestController
@RequestMapping("/conciertos")

public class ConciertosController{
    private final ConciertosService conciertosService;

    public ConciertosController(ConciertosService conciertosService) {
        this.conciertosService = conciertosService;
    }

    @GetMapping
    public List<Conciertos> getAllConciertos() {
        return conciertosService.getAllConciertos();
    }

    @GetMapping("/{id}")
    public Conciertos getConciertoById(@PathVariable Integer id) {
        return conciertosService.getConciertoById(id);
    }

    @PostMapping
    public Conciertos createConcierto(@Valid @RequestBody Conciertos concierto) {
        return conciertosService.createConcierto(concierto);
    }

    @PutMapping("/{id}")
    public Conciertos updateConcierto(@PathVariable Integer id, @Valid @RequestBody Conciertos concierto) {
        return conciertosService.updateConcierto(id, concierto);
    }

    @DeleteMapping("/{id}")
    public void deleteConcierto(@PathVariable Integer id) {
        conciertosService.deleteConcierto(id);
    }
}


