package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.job_board.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
