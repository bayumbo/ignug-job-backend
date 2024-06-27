package com.bolsaempleo.backend.app.services;

import java.util.List;
import java.util.Optional;
import com.bolsaempleo.backend.app.dto.ProfessionalDto;
import com.bolsaempleo.backend.app.entities.job_board.Professional;

public interface ProfessionalService {

    List<Professional> findAll();
    Optional<Professional> findById(Long Id);
    Professional save(Professional professional);
    Optional<Professional> update(Professional professional, Long id);
    void remove(Long id);
    ProfessionalDto findByIdDto(Long Id);
}
