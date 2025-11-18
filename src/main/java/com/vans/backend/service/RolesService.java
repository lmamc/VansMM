package com.vans.backend.service;

import org.springframework.stereotype.Service;
import com.vans.backend.exception.ResourceNotFoundException;
import java.util.List;
import com.vans.backend.entity.Roles;
import com.vans.backend.repository.RolesRepository;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;


    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<Roles> getAllRoles(){
        return rolesRepository.findAll();
    }

    public Roles getRolesById(Integer id){
        return rolesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
    }


    public Roles saveRol(Roles rol){
        return rolesRepository.save(rol);
    }

    public Roles createRoles(Roles roles){
        return rolesRepository.save(roles);
    }

    public void deleteRol(Integer id){
        rolesRepository.deleteById(id);
    }




}
