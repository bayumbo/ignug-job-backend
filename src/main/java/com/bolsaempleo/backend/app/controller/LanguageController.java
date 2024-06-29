package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.LanguageDto;
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
    public List<LanguageDto> getAllLanguages() {
        return languageService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Long id) {
        LanguageDto languageDto = languageService.findById(id);
        if (languageDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(languageDto);
    }

    @PostMapping
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody LanguageDto languageDto) {
        LanguageDto createdLanguageDto = languageService.save(languageDto);
        return ResponseEntity.ok(createdLanguageDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> updateLanguage(@PathVariable Long id, @RequestBody LanguageDto languageDto) {
        LanguageDto updatedLanguageDto = languageService.updateLanguage(id, languageDto);
        if (updatedLanguageDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedLanguageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        languageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
