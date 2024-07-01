package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.ExperienceDto;
import com.bolsaempleo.backend.app.dto.ExperienceResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> findAll();
    ExperienceResponseDto findById(Long id);
    ExperienceResponseDto saveExperience(ExperienceDto experienceDto);
    ExperienceResponseDto findByType(String type);
    ExperienceDto crearModelo(Experience experience); // Añade este método en la interfaz
}
