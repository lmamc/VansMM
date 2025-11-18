package com.vans.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vans.backend.entity.Roles;
import com.vans.backend.service.RolesService;



@RestController
@RequestMapping("/roles")
public class RolesController{
    private final RolesService rolesService;

    public RolesController(RolesService rolesService){
        this.rolesService = rolesService;
    }

    @GetMapping
    public List<Roles> getRoles(){
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Roles getRoleById (@PathVariable Integer id){
        return rolesService.getRolesById(id);
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles roles){
        return rolesService.createRoles(roles);
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Integer id){
        rolesService.deleteRol(id);
    }

}

