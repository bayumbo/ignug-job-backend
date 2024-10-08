package com.bolsaempleo.backend.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsaempleo.backend.app.entities.job_board.OfferProfessional;

@Repository
public interface OfferProfessionalRepository extends JpaRepository<OfferProfessional,UUID>{

}
