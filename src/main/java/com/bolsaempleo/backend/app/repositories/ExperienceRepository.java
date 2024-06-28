package com.bolsaempleo.backend.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bolsaempleo.backend.app.entities.job_board.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
