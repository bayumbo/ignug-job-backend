package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.LanguageDto;
import com.bolsaempleo.backend.app.dto.LanguageResponseDto;
import com.bolsaempleo.backend.app.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<LanguageResponseDto> getAllLanguages() {
        return languageService.findAll();
    }
    //metodo para mostrar
    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponseDto> getLanguageById(@PathVariable Long id) {
        LanguageResponseDto languageDto = languageService.findById(id);
        if (languageDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(languageDto);
    }
    //metodo para crear
    @PostMapping
    public ResponseEntity<LanguageResponseDto> createLanguage(@RequestBody LanguageDto languageDto) {
        LanguageResponseDto createdLanguageDto = languageService.save(languageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLanguageDto);
    }
    //metodo para actualizar
    @PutMapping("/{id}")
    public ResponseEntity<LanguageResponseDto> updateLanguage(@PathVariable Long id, @RequestBody LanguageDto languageDto) {
        LanguageResponseDto updatedLanguageDto = languageService.updateLanguage(id, languageDto);
        if (updatedLanguageDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedLanguageDto);
    }
    //metodo para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        languageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
