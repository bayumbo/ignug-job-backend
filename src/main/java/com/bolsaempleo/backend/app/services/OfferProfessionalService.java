package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.OfferProfessionalDto;
import com.bolsaempleo.backend.app.dto.OfferProfessionalResponseDto;

public interface OfferProfessionalService {

    OfferProfessionalResponseDto findAll();
    OfferProfessionalResponseDto findById(Long id);
    OfferProfessionalResponseDto save(OfferProfessionalDto offerProfessionalDto);
    OfferProfessionalResponseDto update(Long id, OfferProfessionalDto offerProfessionalDto);
    OfferProfessionalResponseDto deleteById(Long id);
}
