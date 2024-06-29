package com.bolsaempleo.backend.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsaempleo.backend.app.entities.authentication.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{
    

}
