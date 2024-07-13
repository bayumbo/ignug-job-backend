package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.job_board.AcademicFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AcademicFormationRepository extends CrudRepository<AcademicFormation,UUID> {
    List<AcademicFormation> findByDeletedAtIsNull();
}
