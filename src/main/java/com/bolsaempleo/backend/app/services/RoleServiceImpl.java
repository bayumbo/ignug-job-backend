package com.bolsaempleo.backend.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bolsaempleo.backend.app.dto.LocationDto;
import com.bolsaempleo.backend.app.dto.RoleDto;
import com.bolsaempleo.backend.app.dto.RoleResponseDto;
import com.bolsaempleo.backend.app.entities.authentication.Role;
import com.bolsaempleo.backend.app.repositories.RoleRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    public RoleRepository roleRepository;

    @Override
    public RoleResponseDto findAll() {
        List<Role> roles = roleRepository.findAll().stream()
                .collect(Collectors.toList());
        List<RoleDto> roleDtos = roles.stream()
                .map(this::roleDto)
                .collect(Collectors.toList());
        return createResponseDto(roleDtos, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public RoleResponseDto findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public RoleResponseDto save(LocationDto locationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public RoleResponseDto update(Long id, LocationDto locationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public RoleResponseDto deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

        private RoleResponseDto createResponseDto(List<RoleDto> data, String code, String message) {
            RoleResponseDto roleResponseDto = new RoleResponseDto();
            roleResponseDto.setCode(code);
            roleResponseDto.setMessage(message);
            roleResponseDto.setData(data);
        return roleResponseDto;
    }

    private RoleDto roleDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setCreatedAt(role.getCreatedAt());
        dto.setUpdatedAt(role.getUpdatedAt());
        dto.setGuardName(role.getGuardName());
        return dto;
    }
}
