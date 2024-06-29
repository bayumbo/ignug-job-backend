package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.entities.job_board.Skill;
import com.bolsaempleo.backend.app.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill findById(Long id) {
        Optional<Skill> skillOptional = skillRepository.findById(id);
        return skillOptional.orElse(null);
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill update(Long id, Skill skill) {
        if (!skillRepository.existsById(id)) {
            return null;
        }
        skill.setId(id);
        return skillRepository.save(skill);
    }

    public boolean delete(Long id) {
        if (!skillRepository.existsById(id)) {
            return false;
        }
        skillRepository.deleteById(id);
        return true;
    }
}
