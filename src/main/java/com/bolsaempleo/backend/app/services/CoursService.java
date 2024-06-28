package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.CoursDto;
import com.bolsaempleo.backend.app.dto.CoursResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Cours;
import com.bolsaempleo.backend.app.repositories.CoursRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoursService {

    private final CoursRepository coursRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CoursService(CoursRepository coursRepository, ModelMapper modelMapper) {
        this.coursRepository = coursRepository;
        this.modelMapper = modelMapper;
    }

    public List<CoursResponseDto> getAllCourses() {
        List<Cours> courses = coursRepository.findAll();
        return courses.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public CoursResponseDto getCourseById(Long id) {
        Optional<Cours> optionalCourse = coursRepository.findById(id);
        return optionalCourse.map(this::convertToResponseDto).orElse(null);
    }

    public CoursResponseDto createOrUpdateCourse(CoursDto coursDto) {
        Cours course = convertToEntity(coursDto);
        course = coursRepository.save(course);
        return convertToResponseDto(course);
    }

    public void deleteCourseById(Long id) {
        coursRepository.deleteById(id);
    }

    private CoursResponseDto convertToResponseDto(Cours course) {
        return modelMapper.map(course, CoursResponseDto.class);
    }

    private Cours convertToEntity(CoursDto coursDto) {
        return modelMapper.map(coursDto, Cours.class);
    }
}
