package com.bolsaempleo.backend.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;
import com.bolsaempleo.backend.app.services.CompanyProfessionalServiceImpl;

@RestController
@RequestMapping("/companyProfessional")
public class CompanyProfessionalController {

    @Autowired
    private CompanyProfessionalServiceImpl companyProfessionalService;

    @GetMapping("/*")
    @ResponseBody
    public CompanyProfessionalResponseDto listAll(){
        return companyProfessionalService.findAllModel();
    }

}
