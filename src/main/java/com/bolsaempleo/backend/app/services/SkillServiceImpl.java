package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.SkillDto;
import com.bolsaempleo.backend.app.dto.SkillResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Professional;
import com.bolsaempleo.backend.app.entities.job_board.Skill;
import com.bolsaempleo.backend.app.repositories.ProfessionalRepository;
import com.bolsaempleo.backend.app.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final ProfessionalRepository professionalRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository, ProfessionalRepository professionalRepository) {
        this.skillRepository = skillRepository;
        this.professionalRepository = professionalRepository;
    }

    @Override
    public List<SkillResponseDto> findAll() {
        List<Skill> skills = skillRepository.findAllByDeletedAtIsNull();
        return skills.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SkillResponseDto findById(Long id) {
        Optional<Skill> optionalSkill = skillRepository.findByIdAndDeletedAtIsNull(id);
        return optionalSkill.map(this::convertToResponseDTO).orElse(null);
    }

    @Override
    public SkillResponseDto save(SkillDto skillDto) {
        Skill skill = convertToEntity(skillDto);
        skill.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Skill savedSkill = skillRepository.save(skill);
        return convertToResponseDTO(savedSkill);
    }

    @Override
    public SkillResponseDto update(Long id, SkillDto skillDto) {
        Optional<Skill> optionalSkill = skillRepository.findByIdAndDeletedAtIsNull(id);
        if (optionalSkill.isPresent()) {
            Skill skill = optionalSkill.get();
            skill = updateEntity(skill, skillDto);
            skill.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            Skill updatedSkill = skillRepository.save(skill);
            return convertToResponseDTO(updatedSkill);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Skill> optionalSkill = skillRepository.findByIdAndDeletedAtIsNull(id);
        if (optionalSkill.isPresent()) {
            Skill skill = optionalSkill.get();
            skill.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            skillRepository.save(skill);
            return true;
        }
        return false;
    }

    private Skill convertToEntity(SkillDto dto) {
        Skill skill = new Skill();
        skill.setDescription(dto.getDescription());
        skill.setTypeId(dto.getTypeId());
        Optional<Professional> professional = professionalRepository.findById(dto.getProfessionalId());
        professional.ifPresent(skill::setProfessional);
        return skill;
    }

    private Skill updateEntity(Skill skill, SkillDto dto) {
        skill.setDescription(dto.getDescription());
        skill.setTypeId(dto.getTypeId());
        Optional<Professional> professional = professionalRepository.findById(dto.getProfessionalId());
        professional.ifPresent(skill::setProfessional);
        return skill;
    }

    private SkillResponseDto convertToResponseDTO(Skill skill) {
        SkillResponseDto dto = new SkillResponseDto();
        dto.setId(skill.getId());
        dto.setDescription(skill.getDescription());
        dto.setTypeId(skill.getTypeId());
        dto.setProfessionalId(skill.getProfessional().getId());
        dto.setCreatedAt(skill.getCreatedAt());
        dto.setUpdatedAt(skill.getUpdatedAt());
        return dto;
    }
}
