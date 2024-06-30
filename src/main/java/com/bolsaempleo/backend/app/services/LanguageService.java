package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.LanguageDto;
import com.bolsaempleo.backend.app.dto.LanguageResponseDto;

import java.util.List;

public interface LanguageService {
    List<LanguageResponseDto> findAll();

    LanguageResponseDto findById(Long id);

    LanguageResponseDto save(LanguageDto languageDto);

    LanguageResponseDto updateLanguage(Long id, LanguageDto languageDto);

    void deleteById(Long id);
}
