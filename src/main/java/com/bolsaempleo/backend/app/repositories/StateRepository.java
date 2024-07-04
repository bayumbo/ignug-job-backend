package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.core.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findAllByDeletedAtIsNull();
    Optional<State> findByIdAndDeletedAtIsNull(Long id);
}
