package com.bolsaempleo.backend.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bolsaempleo.backend.app.dto.RoleRequest;
import com.bolsaempleo.backend.app.entities.authentication.Role;
import com.bolsaempleo.backend.app.services.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> saveAplicacion(@RequestBody RoleRequest aplicationRequest){

        return new ResponseEntity(roleService.save(aplicationRequest),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllAplicacion(){
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getAplicacionById (@PathVariable Long id){
        return ResponseEntity.ok(roleService.getRole(id));
    }
}
