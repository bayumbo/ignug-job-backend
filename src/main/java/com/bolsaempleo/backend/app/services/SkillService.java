package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.SkillDto;
import com.bolsaempleo.backend.app.dto.SkillResponseDto;

import java.util.List;

public interface SkillService {
    List<SkillResponseDto> findAll();

    SkillResponseDto findById(Long id);

    SkillResponseDto save(SkillDto skillDto);

    SkillResponseDto update(Long id, SkillDto skillDto);

    boolean delete(Long id);
}
