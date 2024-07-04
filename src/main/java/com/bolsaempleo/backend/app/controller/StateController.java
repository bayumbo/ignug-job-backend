package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.StateDto;
import com.bolsaempleo.backend.app.dto.StateResponseDto;
import com.bolsaempleo.backend.app.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<StateResponseDto> getAllStates() {
        return stateService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateResponseDto> getStateById(@PathVariable Long id) {
        StateResponseDto stateDto = stateService.findById(id);
        if (stateDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stateDto);
    }

    @PostMapping
    public ResponseEntity<StateResponseDto> createState(@RequestBody StateDto StateDto) {
        StateResponseDto createdStateDto = stateService.save(StateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStateDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateResponseDto> updateState(@PathVariable Long id, @RequestBody StateDto StateDto) {
        StateResponseDto updatedStateDto = stateService.updateState(id, StateDto);
        if (updatedStateDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        stateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
