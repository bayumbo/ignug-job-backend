package com.bolsaempleo.backend.app.services;

import java.util.UUID;

import com.bolsaempleo.backend.app.dto.OfferProfessionalDto;
import com.bolsaempleo.backend.app.dto.OfferProfessionalResponseDto;

public interface OfferProfessionalService {

    OfferProfessionalResponseDto findAll();
    OfferProfessionalResponseDto findById(UUID id);
    OfferProfessionalResponseDto save(OfferProfessionalDto offerProfessionalDto);
    OfferProfessionalResponseDto update(UUID id, OfferProfessionalDto offerProfessionalDto);
    OfferProfessionalResponseDto deleteById(UUID id);
}
