package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.job_board.Professional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, UUID> {

}
