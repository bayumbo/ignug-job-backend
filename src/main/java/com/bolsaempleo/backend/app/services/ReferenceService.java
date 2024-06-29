package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.Reference;
import com.bolsaempleo.backend.app.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenceService {

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceService(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    public List<Reference> findAll() {
        return referenceRepository.findAll();
    }

    public Reference findById(Long id) {
        Optional<Reference> referenceOptional = referenceRepository.findById(id);
        return referenceOptional.orElse(null);
    }

    public Reference save(Reference reference) {
        return referenceRepository.save(reference);
    }

    public Reference update(Long id, Reference reference) {
        if (!referenceRepository.existsById(id)) {
            return null;
        }
        reference.setId(id);
        return referenceRepository.save(reference);
    }

    public boolean delete(Long id) {
        if (!referenceRepository.existsById(id)) {
            return false;
        }
        referenceRepository.deleteById(id);
        return true;
    }
}
