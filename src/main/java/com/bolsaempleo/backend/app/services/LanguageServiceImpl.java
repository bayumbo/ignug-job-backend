package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.LanguageDto;
import com.bolsaempleo.backend.app.entities.job_board.Language;
import com.bolsaempleo.backend.app.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDto> findAll() {
        List<Language> languages = languageRepository.findAll();
        return languages.stream()
                .map(LanguageDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageDto findById(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return new LanguageDto(optionalLanguage.get());
        }
        return null;
    }

    @Override
    public LanguageDto save(LanguageDto languageDto) {
        Language language = new Language();
       
        return new LanguageDto(language);
    }

    @Override
    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public LanguageDto updateLanguage(Long id, LanguageDto languageDto) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
           
            return new LanguageDto(language);
        }
        return null;
    }

  
}
