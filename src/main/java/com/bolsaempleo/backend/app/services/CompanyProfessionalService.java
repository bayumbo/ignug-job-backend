package com.bolsaempleo.backend.app.services;


import java.util.UUID;

import com.bolsaempleo.backend.app.dto.CompanyProfessionalDto;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;


public interface CompanyProfessionalService {

    //List<CompanyProfessional> findAll();
    CompanyProfessionalResponseDto findAll();
    CompanyProfessionalResponseDto findById(UUID id);
    CompanyProfessionalResponseDto save(CompanyProfessionalDto CompanyProfessionalDto);
    CompanyProfessionalResponseDto update(UUID id, CompanyProfessionalDto CompanyProfessionalDto);
    CompanyProfessionalResponseDto deleteById(UUID id);
}
