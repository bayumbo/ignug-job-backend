package com.bolsaempleo.backend.app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bolsaempleo.backend.app.dto.ProfessionalDto;
import com.bolsaempleo.backend.app.entities.job_board.Professional;

public interface ProfessionalService {

    List<Professional> findAll();
    Optional<Professional> findById(UUID Id);
    Professional save(Professional professional);
    Optional<Professional> update(Professional professional, UUID id);
    void remove(UUID id);
    ProfessionalDto findByIdDto(UUID Id);
}
