package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.ReferenceDto;
import com.bolsaempleo.backend.app.dto.ReferenceResponseDto;
import com.bolsaempleo.backend.app.services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/references")
public class ReferenceController {

    @Autowired
    private ReferenceService referenceService;

    @GetMapping
    public ResponseEntity<List<ReferenceResponseDto>> getAllReferences() {
        List<ReferenceResponseDto> references = referenceService.findAll();
        return ResponseEntity.ok(references);
    }
    //metodo para mostrar
    @GetMapping("/{id}")
    public ResponseEntity<ReferenceResponseDto> getReferenceById(@PathVariable UUID id) {
        ReferenceResponseDto reference = referenceService.findById(id);
        if (reference != null) {
            return ResponseEntity.ok(reference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //metodo para crear
    @PostMapping
    public ResponseEntity<ReferenceResponseDto> createReference(@RequestBody ReferenceDto referenceDto) {
        ReferenceResponseDto createdReference = referenceService.save(referenceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReference);
    }
    //metodo para actualizar
    @PutMapping("/{id}")
    public ResponseEntity<ReferenceResponseDto> updateReference(@PathVariable UUID id, @RequestBody ReferenceDto referenceDto) {
        ReferenceResponseDto updatedReference = referenceService.update(id, referenceDto);
        if (updatedReference != null) {
            return ResponseEntity.ok(updatedReference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //metodo para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReference(@PathVariable UUID id) {
        boolean deleted = referenceService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
