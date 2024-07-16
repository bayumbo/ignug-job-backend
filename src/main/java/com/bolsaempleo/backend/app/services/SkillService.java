package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.SkillDto;
import com.bolsaempleo.backend.app.dto.SkillResponseDto;

import java.util.List;
import java.util.UUID;

public interface SkillService {
    List<SkillResponseDto> findAll();

    SkillResponseDto findById(UUID id);

    SkillResponseDto save(SkillDto skillDto);

    SkillResponseDto update(UUID id, SkillDto skillDto);

    boolean delete(UUID id);
}
