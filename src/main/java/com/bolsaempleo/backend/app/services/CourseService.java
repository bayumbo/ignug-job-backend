package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.CourseDto;
import com.bolsaempleo.backend.app.dto.CourseResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Cours;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    List<Cours> findAll();
    CourseResponseDto findById(UUID id);
    CourseResponseDto saveCourse(CourseDto courseDto);
    CourseResponseDto findByType(String type); // Define este método si es necesario
    void deleteCourse(UUID id); // Añadir esta línea
    CourseResponseDto findAllDto();
}
