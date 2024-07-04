package com.bolsaempleo.backend.app.repositories;

import com.bolsaempleo.backend.app.entities.core.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}