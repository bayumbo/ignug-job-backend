package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.CompanyProfessionalDto;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;
import com.bolsaempleo.backend.app.dto.CourseDto;
import com.bolsaempleo.backend.app.dto.CourseResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.CompanyProfessional;
import com.bolsaempleo.backend.app.entities.job_board.Cours;
import com.bolsaempleo.backend.app.repositories.CourseRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

     
    @Override
    public List<Cours> findAll() {
        return courseRepository.findByDeletedAtIsNull();
    }

    @Override
    public CourseResponseDto findById(Long id) {
        CourseResponseDto responseDto = new CourseResponseDto();
        try {
            Cours course = courseRepository.findById(id).filter(c -> c.getDeletedAt() == null).orElse(null);
            if (course != null) {
                responseDto.setCode(ComunEnum.CORRECTO.toString());
                responseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                responseDto.setData(crearModelo(course));
            } else {
                responseDto.setCode(ComunEnum.RECURSOVACIO.toString());
                responseDto.setMessage(ComunEnum.MENSAJESINDATOS.getDescripcion());
            }
        } catch (Exception e) {
            responseDto.setCode(ComunEnum.RECURSOVACIO.toString());
            responseDto.setMessage(ComunEnum.MENSAJESINDATOS.getDescripcion());
            e.printStackTrace();
        }
        return responseDto;
    }

    @Override
    public CourseResponseDto saveCourse(CourseDto courseDto) {
        CourseResponseDto responseDto = new CourseResponseDto();
        try {
            Cours course = new Cours();
            // Asignar los valores del DTO al entity Course
            course.setCertificationTypeId(courseDto.getCertificationTypeId());
            course.setCreatedAt(courseDto.getCreatedAt());
            course.setDeletedAt(null); // Ensure deletedAt is null when creating or updating
            course.setDescription(courseDto.getDescription());
            course.setEndedAt(courseDto.getEndedAt());
            course.setHours(courseDto.getHours());
            course.setInstitution(courseDto.getInstitution());
            course.setName(courseDto.getName());
            course.setStartedAt(courseDto.getStartedAt());
            course.setTypeId(courseDto.getTypeId());
            course.setUpdatedAt(courseDto.getUpdatedAt());

            // Guardar el curso
            course = courseRepository.save(course);

            // Preparar la respuesta
            responseDto.setCode(ComunEnum.CORRECTO.toString());
            responseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
            responseDto.setData(crearModelo(course));
        } catch (Exception e) {
            responseDto.setCode(ComunEnum.RECURSOVACIO.toString());
            responseDto.setMessage(ComunEnum.MENSAJESINDATOS.getDescripcion());
            e.printStackTrace();
        }
        return responseDto;
    }

    @Override
    public CourseResponseDto findByType(String type) {
        // Implementa la lógica para buscar cursos por tipo si es necesario
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        Cours course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setDeletedAt(Timestamp.from(Instant.now()));
        courseRepository.save(course);
    }

    private CourseDto crearModelo(Cours course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setCertificationTypeId(course.getCertificationTypeId());
        courseDto.setCreatedAt(course.getCreatedAt());
        courseDto.setDeletedAt(course.getDeletedAt());
        courseDto.setDescription(course.getDescription());
        courseDto.setEndedAt(course.getEndedAt());
        courseDto.setHours(course.getHours());
        courseDto.setInstitution(course.getInstitution());
        courseDto.setName(course.getName());
        courseDto.setStartedAt(course.getStartedAt());
        courseDto.setTypeId(course.getTypeId());
        courseDto.setUpdatedAt(course.getUpdatedAt());
        courseDto.setAreaId(course.getCategory() != null ? course.getCategory().getId() : null);
        courseDto.setProfessionalId(course.getProfessional() != null ? course.getProfessional().getId() : null);
        return courseDto;
    }

    @Override
    public CourseResponseDto findAllDto() {
        CourseResponseDto courseResponseDto= new CourseResponseDto();
        List<Cours>cours = new ArrayList<>(); 
        cours= courseRepository.findAll();


        return courseResponseDto;
    }
}
