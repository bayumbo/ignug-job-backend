package com.bolsaempleo.backend.app.controller;

import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.RoleResponseDto;
import com.bolsaempleo.backend.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<RoleResponseDto> getAllLocations() {
        RoleResponseDto roleResponseDto = roleService.findAll();
        return new ResponseEntity<>(roleResponseDto, HttpStatus.OK);
    }
}
