package com.bolsaempleo.backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.ProfessionalUserDto;
import com.bolsaempleo.backend.app.dto.ProfessionalUserResponseDto;
import com.bolsaempleo.backend.app.services.ProfessionalUserService;


@RestController
@RequestMapping("/professionaluser")
public class ProfessionalUserController {

    @Autowired
    public ProfessionalUserService professionalUserService;

     
    @PostMapping
    @ResponseBody
    public ProfessionalUserResponseDto saveProfessionalUser (@RequestBody ProfessionalUserDto dto){
        return professionalUserService.saveProfessionalUserDto(dto);
    }
}
