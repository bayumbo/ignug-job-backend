package com.bolsaempleo.backend.app.services;

import java.util.UUID;

import com.bolsaempleo.backend.app.dto.OfferDto;
import com.bolsaempleo.backend.app.dto.OfferResponseDto;

public interface OfferService {

    OfferResponseDto findAll();
    OfferResponseDto findById(UUID id);
    OfferResponseDto save(OfferDto offerDto);
    OfferResponseDto update(UUID id, OfferDto offerDto);
    OfferResponseDto deleteById(UUID id);
}
