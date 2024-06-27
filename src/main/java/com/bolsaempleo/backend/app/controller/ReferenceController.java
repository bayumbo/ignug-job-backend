package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.entities.job_board.Reference;
import com.bolsaempleo.backend.app.services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/references")
public class ReferenceController {

    private final ReferenceService referenceService;

    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @GetMapping
    public ResponseEntity<List<Reference>> getAllReferences() {
        List<Reference> references = referenceService.findAll();
        return ResponseEntity.ok(references);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reference> getReferenceById(@PathVariable Long id) {
        Reference reference = referenceService.findById(id);
        if (reference != null) {
            return ResponseEntity.ok(reference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reference> createReference(@RequestBody Reference reference) {
        Reference createdReference = referenceService.save(reference);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReference);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reference> updateReference(@PathVariable Long id, @RequestBody Reference reference) {
        Reference updatedReference = referenceService.update(id, reference);
        if (updatedReference != null) {
            return ResponseEntity.ok(updatedReference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReference(@PathVariable Long id) {
        boolean deleted = referenceService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
