package com.bolsaempleo.backend.app.services;

import java.util.List;
import com.bolsaempleo.backend.app.dto.LocationDto;
import com.bolsaempleo.backend.app.dto.LocationResponseDto;

public interface LocationService {
    LocationResponseDto findAll();
    LocationResponseDto findById(Long id);
    LocationResponseDto save(LocationDto locationDto);
    LocationResponseDto update(Long id, LocationDto locationDto);
    LocationResponseDto deleteById(Long id);
}