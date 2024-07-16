package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.ExperienceDto;
import com.bolsaempleo.backend.app.dto.ExperienceResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Experience;

import java.util.List;
import java.util.UUID;

public interface ExperienceService {
    List<Experience> findAll();
    ExperienceResponseDto findById(UUID id);
    ExperienceResponseDto saveExperience(ExperienceDto experienceDto);
    ExperienceResponseDto findByType(String type); // Define este método si es necesario
    ExperienceDto crearModelo(Experience experience);
    void deleteExperience(UUID id); // Añadir esta línea
}
