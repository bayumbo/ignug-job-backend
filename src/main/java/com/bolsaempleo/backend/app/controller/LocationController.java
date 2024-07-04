package com.bolsaempleo.backend.app.controller;

import com.bolsaempleo.backend.app.dto.LocationDto;
import com.bolsaempleo.backend.app.dto.LocationResponseDto;
import com.bolsaempleo.backend.app.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<LocationResponseDto> getAllLocations() {
        LocationResponseDto responseDto = locationService.findAll();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> getLocationById(@PathVariable Long id) {
        LocationResponseDto responseDto = locationService.findById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @PostMapping
    public ResponseEntity<LocationResponseDto> createLocation(@RequestBody LocationDto locationDto) {
        LocationResponseDto responseDto = locationService.save(locationDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationResponseDto> updateLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        LocationResponseDto responseDto = locationService.update(id, locationDto);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationResponseDto> deleteLocation(@PathVariable Long id) {
        LocationResponseDto responseDto = locationService.deleteById(id);
        HttpStatus status = responseDto.getCode().equals("CORRECTO") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseDto, status);
    }
}