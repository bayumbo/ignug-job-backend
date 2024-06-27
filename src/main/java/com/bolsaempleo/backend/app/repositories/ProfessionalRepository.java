package com.bolsaempleo.backend.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.job_board.Professional;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional,Long>{

}
