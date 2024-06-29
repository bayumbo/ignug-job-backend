package com.bolsaempleo.backend.app.services;

import java.util.List;

import com.bolsaempleo.backend.app.dto.RoleRequest;
import com.bolsaempleo.backend.app.entities.authentication.Role;

public interface RoleService {

    Role save (RoleRequest roleRequest);
    List<Role> findAll();
    Role getRole(Long id);
   
}
