package com.bolsaempleo.backend.app.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.bolsaempleo.backend.app.dto.OfferProfessionalDto;
import com.bolsaempleo.backend.app.dto.OfferProfessionalResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.OfferProfessional;
import com.bolsaempleo.backend.app.repositories.OfferProfessionalRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;

public class OfferProfessionalServiceImpl implements OfferProfessionalService{

    @Autowired
    private OfferProfessionalRepository offerProfessionalRepository;

    @Override
    public OfferProfessionalResponseDto findAll() {
        List<OfferProfessional> offerProfessionals = offerProfessionalRepository.findAll().stream()
                .collect(Collectors.toList());

        List<OfferProfessionalDto> offerDtos = offerProfessionals.stream()
                .map(this::toOfferProfessionalDto)
                .collect(Collectors.toList());
        return createResponseDto(offerDtos, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private OfferProfessionalResponseDto createResponseDto(List<OfferProfessionalDto> data, String code, String message) {
        OfferProfessionalResponseDto responseDto = new OfferProfessionalResponseDto();
        responseDto.setCode(code);
        responseDto.setMessage(message);
        responseDto.setData(data);
        return responseDto;
    }

    private OfferProfessionalDto toOfferProfessionalDto(OfferProfessional offerProfessional) {
        OfferProfessionalDto dto = new OfferProfessionalDto();
        dto.setStateId(offerProfessional.getStateId());
        dto.setCreatedAt(offerProfessional.getCreatedAt());
        dto.setUpdatedAt(offerProfessional.getUpdatedAt());
        dto.setOffer(offerProfessional.getOffer());
        dto.setProfessional(offerProfessional.getProfessional());
        return dto;
    }

    @Override
    public OfferProfessionalResponseDto findById(Long id) {
        OfferProfessional offerProfessional = offerProfessionalRepository.findById(id)
                .orElse(null);

        if (offerProfessional == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }
        return createResponseDto(List.of(toOfferProfessionalDto(offerProfessional)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public OfferProfessionalResponseDto save(OfferProfessionalDto offerProfessionalDto) {
        OfferProfessional offerProfessional = toOfferProfessional(offerProfessionalDto);
        offerProfessional.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        OfferProfessional savedOfferProfessional = offerProfessionalRepository.save(offerProfessional);
        return createResponseDto(List.of(toOfferProfessionalDto(savedOfferProfessional)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private OfferProfessional toOfferProfessional(OfferProfessionalDto dto) {
        OfferProfessional offerProfessional = new OfferProfessional();
        dto.setStateId(offerProfessional.getStateId());
        dto.setCreatedAt(offerProfessional.getCreatedAt());
        dto.setUpdatedAt(offerProfessional.getUpdatedAt());
        dto.setOffer(offerProfessional.getOffer()!= null ? offerProfessional.getOffer() : null);
        dto.setProfessional(offerProfessional.getProfessional()!= null ? offerProfessional.getProfessional() : null);
        return offerProfessional;
    }

    @Override
    public OfferProfessionalResponseDto update(Long id, OfferProfessionalDto offerProfessionalDto) {
        OfferProfessional offerProfessional = offerProfessionalRepository.findById(id)
                .orElse(null);

        if (offerProfessional == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        updateOfferProfessionalFromDto(offerProfessionalDto, offerProfessional);
        offerProfessional.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        OfferProfessional updatedOfferProfessional = offerProfessionalRepository.save(offerProfessional);

        return createResponseDto(List.of(toOfferProfessionalDto(updatedOfferProfessional)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private void updateOfferProfessionalFromDto(OfferProfessionalDto dto, OfferProfessional offerProfessional) {
        offerProfessional.setStateId(dto.getStateId());
        offerProfessional.setUpdatedAt(dto.getUpdatedAt());
        offerProfessional.setCreatedAt(dto.getCreatedAt());
        offerProfessional.setOffer(dto.getOffer());
        offerProfessional.setProfessional(dto.getProfessional());
    }
    @Override
    public OfferProfessionalResponseDto deleteById(Long id) {
        OfferProfessional offerProfessional = offerProfessionalRepository.findById(id).orElse(null);

        if (offerProfessional == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }
        offerProfessionalRepository.save(offerProfessional);
        return createResponseDto(null, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

}
