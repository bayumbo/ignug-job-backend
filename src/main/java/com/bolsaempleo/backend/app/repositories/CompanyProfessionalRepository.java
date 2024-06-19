package com.bolsaempleo.backend.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bolsaempleo.backend.app.entities.job_board.CompanyProfessional;

@Repository
public interface CompanyProfessionalRepository extends JpaRepository<CompanyProfessional,Long>{

        @Query("select u from CompanyProfessional u")
        List<CompanyProfessional> findAllCompanyProfessional();
}
