package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.SkillDto;
import com.bolsaempleo.backend.app.dto.SkillResponseDto;
import com.bolsaempleo.backend.app.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<SkillResponseDto>> getAllSkills() {
        List<SkillResponseDto> skills = skillService.findAll();
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillResponseDto> getSkillById(@PathVariable Long id) {
        SkillResponseDto skill = skillService.findById(id);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SkillResponseDto> createSkill(@RequestBody SkillDto SkillDto) {
        SkillResponseDto createdSkill = skillService.save(SkillDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSkill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillResponseDto> updateSkill(@PathVariable Long id, @RequestBody SkillDto SkillDto) {
        SkillResponseDto updatedSkill = skillService.update(id, SkillDto);
        if (updatedSkill != null) {
            return ResponseEntity.ok(updatedSkill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        boolean deleted = skillService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
