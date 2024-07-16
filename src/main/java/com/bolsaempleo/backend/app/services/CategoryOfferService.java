package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.CategoryOffer;
import com.bolsaempleo.backend.app.repositories.CategoryOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryOfferService {

    private final CategoryOfferRepository categoryOfferRepository;

    @Autowired
    public CategoryOfferService(CategoryOfferRepository categoryOfferRepository) {
        this.categoryOfferRepository = categoryOfferRepository;
    }

    public List<CategoryOffer> findAll() {
        return categoryOfferRepository.findAll();
    }

    public CategoryOffer findById(UUID id) {
        Optional<CategoryOffer> categoryOfferOptional = categoryOfferRepository.findById(id);
        return categoryOfferOptional.orElse(null);
    }

    public CategoryOffer save(CategoryOffer categoryOffer) {
        return categoryOfferRepository.save(categoryOffer);
    }

    public CategoryOffer update(UUID id, CategoryOffer categoryOffer) {
        if (!categoryOfferRepository.existsById(id)) {
            return null;
        }
        categoryOffer.setId(id);
        return categoryOfferRepository.save(categoryOffer);
    }

    public boolean delete(UUID id) {
        if (!categoryOfferRepository.existsById(id)) {
            return false;
        }
        categoryOfferRepository.deleteById(id);
        return true;
    }
}
