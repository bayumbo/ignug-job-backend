package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.Language;
import com.bolsaempleo.backend.app.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        return optionalLanguage.orElse(null);
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }
}
