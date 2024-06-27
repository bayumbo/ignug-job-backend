package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.entities.job_board.Language;
import com.bolsaempleo.backend.app.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
        Language language = languageService.findById(id);
        if (language == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(language);
    }

    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageService.save(language);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language languageDetails) {
        Language language = languageService.findById(id);
        if (language == null) {
            return ResponseEntity.notFound().build();
        }

        language.setCreatedAt(languageDetails.getCreatedAt());
        language.setDeletedAt(languageDetails.getDeletedAt());
        language.setIdiomId(languageDetails.getIdiomId());
        language.setReadLevelId(languageDetails.getReadLevelId());
        language.setSpokenLevelId(languageDetails.getSpokenLevelId());
        language.setUpdatedAt(languageDetails.getUpdatedAt());
        language.setWrittenLevelId(languageDetails.getWrittenLevelId());
        language.setProfessional(languageDetails.getProfessional());

        Language updatedLanguage = languageService.save(language);
        return ResponseEntity.ok(updatedLanguage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        Language language = languageService.findById(id);
        if (language == null) {
            return ResponseEntity.notFound().build();
        }

        languageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
