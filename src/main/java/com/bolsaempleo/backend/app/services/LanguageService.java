package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.LanguageDto;
import com.bolsaempleo.backend.app.dto.LanguageResponseDto;

import java.util.List;
import java.util.UUID;

public interface LanguageService {
   
    List<LanguageResponseDto> findAll();

    LanguageResponseDto findById(UUID id);

    LanguageResponseDto save(LanguageDto languageDto);

    LanguageResponseDto updateLanguage(UUID id, LanguageDto languageDto);

    void deleteById(UUID id);
}
