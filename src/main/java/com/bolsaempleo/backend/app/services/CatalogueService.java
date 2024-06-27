package com.bolsaempleo.backend.app.services;

import java.util.List;
import java.util.Optional;
import com.bolsaempleo.backend.app.dto.CatalogueDto;
import com.bolsaempleo.backend.app.dto.CatalogueResponseDto;
import com.bolsaempleo.backend.app.entities.core.Catalogue;

public interface CatalogueService {

    List<Catalogue> findAll();
    Optional<Catalogue> findById(Long Id);
    Catalogue save(Catalogue catalogue);
    Optional<Catalogue> update(Catalogue catalogue, Long id);
    void remove(Long id);
    CatalogueResponseDto findByIdDto(Long Id);
    CatalogueResponseDto findByTypeDes(String type);
    CatalogueResponseDto saveCatalogue(CatalogueDto catalogueDto);
}
