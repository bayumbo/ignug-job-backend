package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.entities.job_board.AcademicFormation;
import com.bolsaempleo.backend.app.services.AcademicFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academic-formations")
public class AcademicFormationController {

    private final AcademicFormationService academicFormationService;

    @Autowired
    public AcademicFormationController(AcademicFormationService academicFormationService) {
        this.academicFormationService = academicFormationService;
    }

    @GetMapping
    public ResponseEntity<List<AcademicFormation>> getAllAcademicFormations() {
        List<AcademicFormation> academicFormations = academicFormationService.getAllAcademicFormations();
        return ResponseEntity.ok(academicFormations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicFormation> getAcademicFormationById(@PathVariable Long id) {
        Optional<AcademicFormation> academicFormation = academicFormationService.getAcademicFormationById(id);
        return academicFormation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AcademicFormation> createAcademicFormation(@RequestBody AcademicFormation academicFormation) {
        AcademicFormation createdFormation = academicFormationService.saveOrUpdateAcademicFormation(academicFormation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFormation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicFormation> updateAcademicFormation(@PathVariable Long id, @RequestBody AcademicFormation academicFormation) {
        academicFormation.setId(id);
        AcademicFormation updatedFormation = academicFormationService.saveOrUpdateAcademicFormation(academicFormation);
        return ResponseEntity.ok(updatedFormation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicFormation(@PathVariable Long id) {
        academicFormationService.deleteAcademicFormation(id);
        return ResponseEntity.noContent().build();
    }
}
