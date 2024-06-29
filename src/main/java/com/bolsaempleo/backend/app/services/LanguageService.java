package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.LanguageDto;
import java.util.List;

public interface LanguageService {
    List<LanguageDto> findAll();

    LanguageDto findById(Long id);

    LanguageDto save(LanguageDto languageDto);

    LanguageDto updateLanguage(Long id, LanguageDto languageDto);

    void deleteById(Long id);
}
