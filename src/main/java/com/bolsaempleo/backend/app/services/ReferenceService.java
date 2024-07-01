package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.ReferenceDto;
import com.bolsaempleo.backend.app.dto.ReferenceResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Reference;
import com.bolsaempleo.backend.app.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReferenceService {

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceService(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    public List<ReferenceResponseDto> findAll() {
        return referenceRepository.findAllByDeletedAtIsNull().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ReferenceResponseDto findById(Long id) {
        Optional<Reference> referenceOptional = referenceRepository.findByIdAndDeletedAtIsNull(id);
        return referenceOptional.map(this::convertToResponseDTO).orElse(null);
    }

    public ReferenceResponseDto save(ReferenceDto referenceDto) {
        Reference reference = convertToEntity(referenceDto);
        reference.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Reference savedReference = referenceRepository.save(reference);
        return convertToResponseDTO(savedReference);
    }

    public ReferenceResponseDto update(Long id, ReferenceDto referenceDto) {
        Optional<Reference> optionalReference = referenceRepository.findByIdAndDeletedAtIsNull(id);
        if (optionalReference.isPresent()) {
            Reference reference = optionalReference.get();
            reference = updateEntity(reference, referenceDto);
            reference.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            Reference updatedReference = referenceRepository.save(reference);
            return convertToResponseDTO(updatedReference);
        }
        return null;
    }

    public boolean delete(Long id) {
        Optional<Reference> optionalReference = referenceRepository.findByIdAndDeletedAtIsNull(id);
        if (optionalReference.isPresent()) {
            Reference reference = optionalReference.get();
            reference.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            referenceRepository.save(reference);
            return true;
        }
        return false;
    }

    private Reference convertToEntity(ReferenceDto dto) {
        Reference reference = new Reference();
        reference.setContactEmail(dto.getContactEmail());
        reference.setContactName(dto.getContactName());
        reference.setContactPhone(dto.getContactPhone());
        reference.setInstitution(dto.getInstitution());
        reference.setPosition(dto.getPosition());
        return reference;
    }

    private Reference updateEntity(Reference reference, ReferenceDto dto) {
        reference.setContactEmail(dto.getContactEmail());
        reference.setContactName(dto.getContactName());
        reference.setContactPhone(dto.getContactPhone());
        reference.setInstitution(dto.getInstitution());
        reference.setPosition(dto.getPosition());
        return reference;
    }

    private ReferenceResponseDto convertToResponseDTO(Reference reference) {
        ReferenceResponseDto dto = new ReferenceResponseDto();
        dto.setId(reference.getId());
        dto.setContactEmail(reference.getContactEmail());
        dto.setContactName(reference.getContactName());
        dto.setContactPhone(reference.getContactPhone());
        dto.setInstitution(reference.getInstitution());
        dto.setPosition(reference.getPosition());
        dto.setCreatedAt(reference.getCreatedAt());
        dto.setUpdatedAt(reference.getUpdatedAt());
        return dto;
    }
}
