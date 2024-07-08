package com.bolsaempleo.backend.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bolsaempleo.backend.app.entities.job_board.OfferProfessional;

public interface OfferProfessionalRepository extends JpaRepository<OfferProfessional,Long>{

}
