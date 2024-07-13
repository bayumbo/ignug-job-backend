package com.bolsaempleo.backend.app.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalDto;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;
import com.bolsaempleo.backend.app.services.CompanyProfessionalServiceImpl;

@RestController
@RequestMapping("/companyProfessional")
public class CompanyProfessionalController {

    @Autowired
    private CompanyProfessionalServiceImpl companyProfessionalService;

    @GetMapping
    public ResponseEntity<CompanyProfessionalResponseDto> getAll() {
        CompanyProfessionalResponseDto responseDto = companyProfessionalService.findAll();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

       @GetMapping("/{id}")
    public ResponseEntity<CompanyProfessionalResponseDto> getCompanyById(@PathVariable UUID id) {
        CompanyProfessionalResponseDto responseDto = companyProfessionalService.findById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @PostMapping
    public ResponseEntity<CompanyProfessionalResponseDto> createLocation(@RequestBody CompanyProfessionalDto companyProfessionalDto) {
        CompanyProfessionalResponseDto responseDto = companyProfessionalService.save(companyProfessionalDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyProfessionalResponseDto> updateLocation(@PathVariable UUID id, @RequestBody CompanyProfessionalDto companyProfessionalDto) {
        CompanyProfessionalResponseDto responseDto = companyProfessionalService.update(id, companyProfessionalDto);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyProfessionalResponseDto> deleteLocation(@PathVariable UUID id) {
        CompanyProfessionalResponseDto responseDto = companyProfessionalService.deleteById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }
}
