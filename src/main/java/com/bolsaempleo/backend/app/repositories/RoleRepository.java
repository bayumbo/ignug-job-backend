package com.bolsaempleo.backend.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsaempleo.backend.app.entities.authentication.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,UUID>{
    

}
