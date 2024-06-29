package com.bolsaempleo.backend.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaempleo.backend.app.dto.RoleRequest;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.dto.UsersResponseDto;
import com.bolsaempleo.backend.app.entities.authentication.Role;
import com.bolsaempleo.backend.app.entities.job_board.Professional;
import com.bolsaempleo.backend.app.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    public RoleRepository roleRepository;
/* 
    public Role save (RoleRequest roleRequest){
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setGuardName(roleRequest.getGuardName());
        role.setCreatedAt(null);
        role.setUpdatedAt(null);
        return roleRepository.save(role);
    }
    @Override
    @Transactional(readOnly = true )
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true )
    public Role getRole(Long id){
        return roleRepository.findById(id);
    }

    */

    @Override
    public Role save(RoleRequest roleRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Role getRole(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }
}
