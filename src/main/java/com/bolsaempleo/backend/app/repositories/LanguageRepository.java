
package com.bolsaempleo.backend.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bolsaempleo.backend.app.entities.job_board.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
