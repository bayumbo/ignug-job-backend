package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.job_board.AcademicFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicFormationRepository extends JpaRepository<AcademicFormation, Long> {
    List<AcademicFormation> findByDeletedAtIsNull();
}
