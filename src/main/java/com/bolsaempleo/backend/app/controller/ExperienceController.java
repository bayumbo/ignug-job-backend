package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.ExperienceDto;
import com.bolsaempleo.backend.app.dto.ExperienceResponseDto;
import com.bolsaempleo.backend.app.services.ExperienceService;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> getAllExperiences() {
        List<ExperienceDto> experiences = experienceService.findAll().stream()
                .map(experience -> experienceService.crearModelo(experience))
                .collect(Collectors.toList());
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponseDto> getExperienceById(@PathVariable Long id) {
        ExperienceResponseDto responseDto = experienceService.findById(id);
        HttpStatus status = responseDto.getCode().equals(ComunEnum.CORRECTO.toString()) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @PostMapping
    public ResponseEntity<ExperienceResponseDto> createExperience(@RequestBody ExperienceDto experienceDto) {
        ExperienceResponseDto responseDto = experienceService.saveExperience(experienceDto);
        HttpStatus status = responseDto.getCode().equals(ComunEnum.CORRECTO.toString()) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(responseDto, status);
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}
