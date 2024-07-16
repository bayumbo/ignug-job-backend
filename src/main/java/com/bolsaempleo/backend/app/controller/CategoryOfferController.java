package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.entities.job_board.CategoryOffer;
import com.bolsaempleo.backend.app.services.CategoryOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category-offers")
public class CategoryOfferController {

    @Autowired
    private CategoryOfferService categoryOfferService;


    @GetMapping
    public ResponseEntity<List<CategoryOffer>> getAllCategoryOffers() {
        List<CategoryOffer> categoryOffers = categoryOfferService.findAll();
        return ResponseEntity.ok(categoryOffers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOffer> getCategoryOfferById(@PathVariable UUID id) {
        CategoryOffer categoryOffer = categoryOfferService.findById(id);
        if (categoryOffer != null) {
            return ResponseEntity.ok(categoryOffer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryOffer> createCategoryOffer(@RequestBody CategoryOffer categoryOffer) {
        CategoryOffer createdCategoryOffer = categoryOfferService.save(categoryOffer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoryOffer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryOffer> updateCategoryOffer(@PathVariable UUID id, @RequestBody CategoryOffer categoryOffer) {
        CategoryOffer updatedCategoryOffer = categoryOfferService.update(id, categoryOffer);
        if (updatedCategoryOffer != null) {
            return ResponseEntity.ok(updatedCategoryOffer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryOffer(@PathVariable UUID id) {
        boolean deleted = categoryOfferService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
