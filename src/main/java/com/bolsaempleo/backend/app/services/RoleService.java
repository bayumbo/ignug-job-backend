package com.bolsaempleo.backend.app.services;


import com.bolsaempleo.backend.app.dto.LocationDto;
import com.bolsaempleo.backend.app.dto.RoleResponseDto;

public interface RoleService {
 
    RoleResponseDto findAll();
    RoleResponseDto findById(Long id);
    RoleResponseDto save(LocationDto locationDto);
    RoleResponseDto update(Long id, LocationDto locationDto);
    RoleResponseDto deleteById(Long id);
   
}
