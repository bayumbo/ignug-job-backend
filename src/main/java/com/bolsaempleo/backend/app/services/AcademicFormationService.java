package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.AcademicFormation;
import com.bolsaempleo.backend.app.repositories.AcademicFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return academicFormationRepository.findAll();
    }

    public Optional<AcademicFormation> getAcademicFormationById(Long id) {
        return academicFormationRepository.findById(id);
    }

    public AcademicFormation saveOrUpdateAcademicFormation(AcademicFormation academicFormation) {
        return academicFormationRepository.save(academicFormation);
    }

    public void deleteAcademicFormation(Long id) {
        academicFormationRepository.deleteById(id);
    }
}
