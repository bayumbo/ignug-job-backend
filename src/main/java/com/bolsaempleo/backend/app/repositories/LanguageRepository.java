package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.job_board.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findAllByDeletedAtIsNull();
    Optional<Language> findByIdAndDeletedAtIsNull(Long id);
}
