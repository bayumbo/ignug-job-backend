package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.OfferDto;
import com.bolsaempleo.backend.app.dto.OfferResponseDto;

public interface OfferService {

    OfferResponseDto findAll();
    OfferResponseDto findById(Long id);
    OfferResponseDto save(OfferDto offerDto);
    OfferResponseDto update(Long id, OfferDto offerDto);
    OfferResponseDto deleteById(Long id);
}
