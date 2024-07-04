package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.StateDto;
import com.bolsaempleo.backend.app.dto.StateResponseDto;
import com.bolsaempleo.backend.app.entities.core.State;
import com.bolsaempleo.backend.app.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<StateResponseDto> findAll() {
        List<State> states = stateRepository.findAll();
        return states.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StateResponseDto findById(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        return optionalState.map(this::convertToResponseDTO).orElse(null);
    }

    @Override
    public StateResponseDto save(StateDto StateDto) {
        State state = convertToEntity(StateDto);
        state.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        State savedState = stateRepository.save(state);
        return convertToResponseDTO(savedState);
    }

    @Override
    public StateResponseDto updateState(Long id, StateDto StateDto) {
        Optional<State> optionalState = stateRepository.findById(id);
        if (optionalState.isPresent()) {
            State state = optionalState.get();
            state = updateEntity(state, StateDto);
            state.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            State updatedState = stateRepository.save(state);
            return convertToResponseDTO(updatedState);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        if (optionalState.isPresent()) {
            State state = optionalState.get();
            state.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            stateRepository.save(state);
        }
    }

    private State convertToEntity(StateDto dto) {
        State state = new State();
        state.setCode(dto.getCode());
        state.setName(dto.getName());
        return state;
    }

    private State updateEntity(State state, StateDto dto) {
        state.setCode(dto.getCode());
        state.setName(dto.getName());
        return state;
    }

    private StateResponseDto convertToResponseDTO(State state) {
        StateResponseDto dto = new StateResponseDto();
        dto.setId(state.getId());
        dto.setCode(state.getCode());
        dto.setName(state.getName());
        dto.setCreatedAt(state.getCreatedAt());
        dto.setDeletedAt(state.getDeletedAt());
        dto.setUpdatedAt(state.getUpdatedAt());
        return dto;
    }
}
