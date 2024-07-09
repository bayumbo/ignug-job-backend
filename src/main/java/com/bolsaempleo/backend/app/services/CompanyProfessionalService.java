package com.bolsaempleo.backend.app.services;


import com.bolsaempleo.backend.app.dto.CompanyProfessionalDto;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;


public interface CompanyProfessionalService {

    //List<CompanyProfessional> findAll();
    CompanyProfessionalResponseDto findAll();
    CompanyProfessionalResponseDto findById(Long id);
    CompanyProfessionalResponseDto save(CompanyProfessionalDto CompanyProfessionalDto);
    CompanyProfessionalResponseDto update(Long id, CompanyProfessionalDto CompanyProfessionalDto);
    CompanyProfessionalResponseDto deleteById(Long id);
}
