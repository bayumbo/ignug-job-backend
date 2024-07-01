package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.CourseDto;
import com.bolsaempleo.backend.app.dto.CourseResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Cours;

import java.util.List;

public interface CourseService {
    List<Cours> findAll();
    CourseResponseDto findById(Long id);
    CourseResponseDto saveCourse(CourseDto courseDto);
    CourseResponseDto findByType(String type); // Define este método si es necesario
}
