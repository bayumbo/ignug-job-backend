package com.bolsaempleo.backend.app.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bolsaempleo.backend.app.dto.LocationDto;
import com.bolsaempleo.backend.app.dto.LocationResponseDto;
import com.bolsaempleo.backend.app.entities.core.Location;
import com.bolsaempleo.backend.app.repositories.LocationRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationResponseDto findAll() {
        List<Location> locations = locationRepository.findAll().stream()
                .filter(location -> location.getDeletedAt() == null)
                .collect(Collectors.toList());

        List<LocationDto> locationDtos = locations.stream()
                .map(this::toLocationDto)
                .collect(Collectors.toList());

        return createResponseDto(locationDtos, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public LocationResponseDto findById(Long id) {
        Location location = locationRepository.findById(id)
                .filter(loc -> loc.getDeletedAt() == null)
                .orElse(null);

        if (location == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        return createResponseDto(List.of(toLocationDto(location)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public LocationResponseDto save(LocationDto locationDto) {
        Location location = toLocation(locationDto);
        location.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Location savedLocation = locationRepository.save(location);
        return createResponseDto(List.of(toLocationDto(savedLocation)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public LocationResponseDto update(Long id, LocationDto locationDto) {
        Location location = locationRepository.findById(id)
                .filter(loc -> loc.getDeletedAt() == null)
                .orElse(null);

        if (location == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        updateLocationFromDto(locationDto, location);
        location.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Location updatedLocation = locationRepository.save(location);

        return createResponseDto(List.of(toLocationDto(updatedLocation)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public LocationResponseDto deleteById(Long id) {
        Location location = locationRepository.findById(id).orElse(null);

        if (location == null || location.getDeletedAt() != null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        location.setDeletedAt(new Timestamp(System.currentTimeMillis()));
        locationRepository.save(location);

        return createResponseDto(null, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private LocationDto toLocationDto(Location location) {
        LocationDto dto = new LocationDto();
        dto.setId(location.getId());
        dto.setAlpha2Code(location.getAlpha2Code());
        dto.setAlpha3Code(location.getAlpha3Code());
        dto.setCallingCode(location.getCallingCode());
        dto.setCapital(location.getCapital());
        dto.setCode(location.getCode());
        dto.setFlag(location.getFlag());
        dto.setName(location.getName());
        dto.setRegion(location.getRegion());
        dto.setSubregion(location.getSubregion());
        dto.setTimezones(location.getTimezones());
        dto.setTopLevelDomain(location.getTopLevelDomain());
        dto.setCreatedAt(location.getCreatedAt());
        dto.setUpdatedAt(location.getUpdatedAt());
        dto.setParentId(location.getLocation() != null ? location.getLocation().getId() : null);
        dto.setTypeId(location.getCatalogue() != null ? location.getCatalogue().getId() : null);
        return dto;
    }

    private Location toLocation(LocationDto dto) {
        Location location = new Location();
        location.setAlpha2Code(dto.getAlpha2Code());
        location.setAlpha3Code(dto.getAlpha3Code());
        location.setCallingCode(dto.getCallingCode());
        location.setCapital(dto.getCapital());
        location.setCode(dto.getCode());
        location.setFlag(dto.getFlag());
        location.setName(dto.getName());
        location.setRegion(dto.getRegion());
        location.setSubregion(dto.getSubregion());
        location.setTimezones(dto.getTimezones());
        location.setTopLevelDomain(dto.getTopLevelDomain());
        return location;
    }

    private void updateLocationFromDto(LocationDto dto, Location location) {
        location.setAlpha2Code(dto.getAlpha2Code());
        location.setAlpha3Code(dto.getAlpha3Code());
        location.setCallingCode(dto.getCallingCode());
        location.setCapital(dto.getCapital());
        location.setCode(dto.getCode());
        location.setFlag(dto.getFlag());
        location.setName(dto.getName());
        location.setRegion(dto.getRegion());
        location.setSubregion(dto.getSubregion());
        location.setTimezones(dto.getTimezones());
        location.setTopLevelDomain(dto.getTopLevelDomain());
    }

    private LocationResponseDto createResponseDto(List<LocationDto> data, String code, String message) {
        LocationResponseDto responseDto = new LocationResponseDto();
        responseDto.setCode(code);
        responseDto.setMessage(message);
        responseDto.setData(data);
        return responseDto;
    }
}