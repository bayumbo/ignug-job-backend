package com.bolsaempleo.backend.app.services;


import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalDto;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.CompanyProfessional;
import com.bolsaempleo.backend.app.repositories.CompanyProfessionalRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;


@Service
public class CompanyProfessionalServiceImpl implements CompanyProfessionalService{

    @Autowired
    private CompanyProfessionalRepository companyProfessionalRepository;

    @Override
    public CompanyProfessionalResponseDto findAll() {
        List<CompanyProfessional> companyProfessionals = companyProfessionalRepository.findAll().stream()
                .collect(Collectors.toList());

        List<CompanyProfessionalDto> companyProfessionalDtos = companyProfessionals.stream()
                .map(this::toCompanyProfessionalDto)
                .collect(Collectors.toList());

        return createResponseDto(companyProfessionalDtos, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }
private CompanyProfessionalDto toCompanyProfessionalDto(CompanyProfessional companyProfessional) {
    CompanyProfessionalDto dto = new CompanyProfessionalDto();
        dto.setProfessional(companyProfessional.getProfessional() != null ? companyProfessional.getProfessional() : null);
        dto.setCreatedAt(companyProfessional.getCreatedAt());
        dto.setUpdatedAt(companyProfessional.getUpdatedAt());
        dto.setCompany(companyProfessional.getCompany()!= null ? companyProfessional.getCompany() : null);
        dto.setStateId(companyProfessional.getStateId());
        return dto;
    }

    private CompanyProfessionalResponseDto createResponseDto(List<CompanyProfessionalDto> data, String code, String message) {
        CompanyProfessionalResponseDto responseDto = new CompanyProfessionalResponseDto();
        responseDto.setCode(code);
        responseDto.setMessage(message);
        responseDto.setData(data);
        return responseDto;
    }

    @Override
    public CompanyProfessionalResponseDto findById(UUID id) {
        CompanyProfessional companyProfessional = companyProfessionalRepository.findById(id)
                .orElse(null);

        if (companyProfessional == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        return createResponseDto(List.of(toCompanyProfessionalDto(companyProfessional)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public CompanyProfessionalResponseDto update(UUID id, CompanyProfessionalDto companyProfessionalDto) {
        CompanyProfessional companyProfessional = companyProfessionalRepository.findById(id)
                .orElse(null);

        if (companyProfessional == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        updateLocationFromDto(companyProfessionalDto, companyProfessional);
        companyProfessional.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        CompanyProfessional updatedCompany = companyProfessionalRepository.save(companyProfessional);

        return createResponseDto(List.of(toCompanyProffesionalDto(updatedCompany)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    @Override
    public CompanyProfessionalResponseDto deleteById(UUID id) {
        CompanyProfessional companyProfessional = companyProfessionalRepository.findById(id).orElse(null);

        if (companyProfessional == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }
        companyProfessionalRepository.save(companyProfessional);
        return createResponseDto(null, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private void updateLocationFromDto(CompanyProfessionalDto dto, CompanyProfessional companyProfessional) {
        companyProfessional.setProfessional(dto.getProfessional());
        companyProfessional.setCreatedAt(dto.getCreatedAt());
        companyProfessional.setUpdatedAt(dto.getUpdatedAt());
        companyProfessional.setCompany(dto.getCompany());
        companyProfessional.setStateId(dto.getStateId());
    }


    @Override
    public CompanyProfessionalResponseDto save(CompanyProfessionalDto companyProfessionalDto) {
        CompanyProfessional companyProfessional = toCompanyProffesional(companyProfessionalDto);
        companyProfessional.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        CompanyProfessional savedCompanyProffesional = companyProfessionalRepository.save(companyProfessional);
        return createResponseDto(List.of(toCompanyProffesionalDto(savedCompanyProffesional)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private CompanyProfessional toCompanyProffesional(CompanyProfessionalDto dto) {
        CompanyProfessional companyProfessional = new CompanyProfessional();
        dto.setProfessional(companyProfessional.getProfessional() );
        dto.setCreatedAt(companyProfessional.getCreatedAt());
        dto.setUpdatedAt(companyProfessional.getUpdatedAt());
        dto.setCompany(companyProfessional.getCompany());
        dto.setStateId(companyProfessional.getStateId());
        return companyProfessional;
    }
    private CompanyProfessionalDto toCompanyProffesionalDto(CompanyProfessional companyProfessional) {
        CompanyProfessionalDto dto = new CompanyProfessionalDto();
        dto.setProfessional(companyProfessional.getProfessional() );
        dto.setCreatedAt(companyProfessional.getCreatedAt());
        dto.setUpdatedAt(companyProfessional.getUpdatedAt());
        dto.setCompany(companyProfessional.getCompany());
        dto.setStateId(companyProfessional.getStateId());
        return dto;
    }
}
