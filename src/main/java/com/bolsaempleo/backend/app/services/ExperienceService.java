package com.bolsaempleo.backend.app.services;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bolsaempleo.backend.app.dto.ExperienceDto;
import com.bolsaempleo.backend.app.dto.ExperienceResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Experience;
import com.bolsaempleo.backend.app.repositories.ExperienceRepository;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ExperienceResponseDto> findAll() {
        List<Experience> experiences = experienceRepository.findAll();
        return experiences.stream()
                .map(exp -> modelMapper.map(exp, ExperienceResponseDto.class))
                .toList();
    }

    public ExperienceResponseDto findById(Long id) {
        Optional<Experience> experience = experienceRepository.findById(id);
        return experience.map(exp -> modelMapper.map(exp, ExperienceResponseDto.class))
                         .orElse(null);
    }

    public ExperienceResponseDto save(ExperienceDto experienceDto) {
        Experience experience = modelMapper.map(experienceDto, Experience.class);
        Experience savedExperience = experienceRepository.save(experience);
        return modelMapper.map(savedExperience, ExperienceResponseDto.class);
    }

    public ExperienceResponseDto update(Long id, ExperienceDto experienceDto) {
        if (experienceRepository.existsById(id)) {
            Experience experience = modelMapper.map(experienceDto, Experience.class);
            experience.setId(id);
            Experience updatedExperience = experienceRepository.save(experience);
            return modelMapper.map(updatedExperience, ExperienceResponseDto.class);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (experienceRepository.existsById(id)) {
            experienceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
