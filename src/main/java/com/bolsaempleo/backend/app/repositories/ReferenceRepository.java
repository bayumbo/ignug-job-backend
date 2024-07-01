package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.job_board.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    List<Reference> findAllByDeletedAtIsNull();
    Optional<Reference> findByIdAndDeletedAtIsNull(Long id);
}
