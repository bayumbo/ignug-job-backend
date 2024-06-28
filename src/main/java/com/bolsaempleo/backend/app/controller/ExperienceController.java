package com.bolsaempleo.backend.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bolsaempleo.backend.app.dto.ExperienceDto;
import com.bolsaempleo.backend.app.dto.ExperienceResponseDto;
import com.bolsaempleo.backend.app.services.ExperienceService;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public List<ExperienceResponseDto> getAllExperiences() {
        return experienceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponseDto> getExperienceById(@PathVariable Long id) {
        ExperienceResponseDto experience = experienceService.findById(id);
        if (experience != null) {
            return ResponseEntity.ok(experience);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ExperienceResponseDto> createExperience(@RequestBody ExperienceDto experienceDto) {
        ExperienceResponseDto createdExperience = experienceService.save(experienceDto);
        return ResponseEntity.ok(createdExperience);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponseDto> updateExperience(@PathVariable Long id, @RequestBody ExperienceDto experienceDto) {
        ExperienceResponseDto updatedExperience = experienceService.update(id, experienceDto);
        if (updatedExperience != null) {
            return ResponseEntity.ok(updatedExperience);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        boolean deleted = experienceService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}