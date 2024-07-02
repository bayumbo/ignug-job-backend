package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.ExperienceDto;
import com.bolsaempleo.backend.app.dto.ExperienceResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Experience;
import com.bolsaempleo.backend.app.repositories.ExperienceRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public ExperienceResponseDto findById(Long id) {
        ExperienceResponseDto responseDto = new ExperienceResponseDto();
        try {
            Experience experience = experienceRepository.findById(id).orElse(null);
            if (experience != null) {
                responseDto.setCode(ComunEnum.CORRECTO.toString());
                responseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                responseDto.setExperienceDto(crearModelo(experience));
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
    public ExperienceResponseDto saveExperience(ExperienceDto experienceDto) {
        ExperienceResponseDto responseDto = new ExperienceResponseDto();
        try {
            Experience experience = new Experience();
            // Asignar los valores del DTO al entity Experience
            experience.setActivities(experienceDto.getActivities()); // Asegúrate de que activities sea String en ExperienceDto
            experience.setAreaId(experienceDto.getAreaId());
            experience.setCreatedAt(experienceDto.getCreatedAt());
            experience.setDeletedAt(experienceDto.getDeletedAt());
            experience.setEmployer(experienceDto.getEmployer());
            experience.setEndedAt(experienceDto.getEndedAt());
            experience.setPosition(experienceDto.getPosition());
            experience.setReasonLeave(experienceDto.getReasonLeave());
            experience.setStartedAt(experienceDto.getStartedAt());
            experience.setUpdatedAt(experienceDto.getUpdatedAt());
            experience.setWorked(experienceDto.getWorked());

            // Guardar la experiencia
            experience = experienceRepository.save(experience);

            // Preparar la respuesta
            responseDto.setCode(ComunEnum.CORRECTO.toString());
            responseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
            responseDto.setExperienceDto(crearModelo(experience));
        } catch (Exception e) {
            responseDto.setCode(ComunEnum.RECURSOVACIO.toString());
            responseDto.setMessage(ComunEnum.MENSAJESINDATOS.getDescripcion());
            e.printStackTrace();
        }
        return responseDto;
    }

    @Override
    public ExperienceResponseDto findByType(String type) {
        // Implementa la lógica para buscar experiencias por tipo si es necesario
        return null;
    }

    @Override
    public ExperienceDto crearModelo(Experience experience) {
        ExperienceDto experienceDto = new ExperienceDto();
        experienceDto.setId(experience.getId());
        experienceDto.setActivities(experience.getActivities().toString()); // Asegúrate de que activities sea String en ExperienceDto
        experienceDto.setAreaId(experience.getAreaId());
        experienceDto.setCreatedAt(experience.getCreatedAt());
        experienceDto.setDeletedAt(experience.getDeletedAt());
        experienceDto.setEmployer(experience.getEmployer());
        experienceDto.setEndedAt(experience.getEndedAt());
        experienceDto.setPosition(experience.getPosition());
        experienceDto.setReasonLeave(experience.getReasonLeave());
        experienceDto.setStartedAt(experience.getStartedAt());
        experienceDto.setUpdatedAt(experience.getUpdatedAt());
        experienceDto.setWorked(experience.getWorked());
        experienceDto.setProfessionalId(experience.getProfessional() != null ? experience.getProfessional().getId() : null);
        return experienceDto;
    }

    @Override
    public void deleteExperience(Long id) {
        Experience experience = experienceRepository.findById(id).orElseThrow(() -> new RuntimeException("Experience not found"));
        experience.setDeletedAt(Timestamp.from(Instant.now()));
        experienceRepository.save(experience);
    }
}
