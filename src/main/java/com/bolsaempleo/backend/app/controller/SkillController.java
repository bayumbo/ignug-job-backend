package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.SkillDto;
import com.bolsaempleo.backend.app.dto.SkillResponseDto;
import com.bolsaempleo.backend.app.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillResponseDto>> getAllSkills() {
        List<SkillResponseDto> skills = skillService.findAll();
        return ResponseEntity.ok(skills);
    }
    //metodo para mostrar 
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<SkillResponseDto> getSkillById(@PathVariable UUID id) {
        SkillResponseDto skill = skillService.findById(id);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //metodo para crear
    @PostMapping
    public ResponseEntity<SkillResponseDto> createSkill(@RequestBody SkillDto skillDto) {
        SkillResponseDto createdSkill = skillService.save(skillDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSkill);
    }
    //metodo para actualizar
    @PutMapping("/{id}")
    public ResponseEntity<SkillResponseDto> updateSkill(@PathVariable UUID id, @RequestBody SkillDto skillDto) {
        SkillResponseDto updatedSkill = skillService.update(id, skillDto);
        if (updatedSkill != null) {
            return ResponseEntity.ok(updatedSkill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //metodo para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable UUID id) {
        boolean deleted = skillService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
