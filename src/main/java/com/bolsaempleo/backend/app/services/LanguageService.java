package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.Language;
import java.util.List;

public interface LanguageService {
    List<Language> findAll();
    Language findById(Long id);
    Language save(Language language);
    void deleteById(Long id);
}
