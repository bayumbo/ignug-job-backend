package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.AcademicFormation;
import com.bolsaempleo.backend.app.repositories.AcademicFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicFormationService {

    private final AcademicFormationRepository academicFormationRepository;

    @Autowired
    public AcademicFormationService(AcademicFormationRepository academicFormationRepository) {
        this.academicFormationRepository = academicFormationRepository;
    }

    public List<AcademicFormation> getAllAcademicFormations() {
        return academicFormationRepository.findByDeletedAtIsNull();
    }

    public Optional<AcademicFormation> getAcademicFormationById(Long id) {
        return academicFormationRepository.findById(id).filter(academicFormation -> academicFormation.getDeletedAt() == null);
    }

    public AcademicFormation saveOrUpdateAcademicFormation(AcademicFormation academicFormation) {
        return academicFormationRepository.save(academicFormation);
    }

    public void deleteAcademicFormation(Long id) {
        Optional<AcademicFormation> existingAcademicFormation = academicFormationRepository.findById(id);
        if (existingAcademicFormation.isPresent()) {
            AcademicFormation academicFormation = existingAcademicFormation.get();
            academicFormation.setDeletedAt(Timestamp.from(Instant.now()));
            academicFormationRepository.save(academicFormation);
        } else {
            throw new RuntimeException("AcademicFormation not found");
        }
    }
}