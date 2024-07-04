package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.StateDto;
import com.bolsaempleo.backend.app.dto.StateResponseDto;

import java.util.List;

public interface StateService {
    List<StateResponseDto> findAll();

    StateResponseDto findById(Long id);

    StateResponseDto save(StateDto stateDto);

    StateResponseDto updateState(Long id, StateDto stateDto);

    void deleteById(Long id);
}
