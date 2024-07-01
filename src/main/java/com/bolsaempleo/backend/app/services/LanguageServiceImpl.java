package com.bolsaempleo.backend.app.services;

import com.bolsaempleo.backend.app.dto.LanguageDto;
import com.bolsaempleo.backend.app.dto.LanguageResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.Language;
import com.bolsaempleo.backend.app.entities.job_board.Professional;
import com.bolsaempleo.backend.app.repositories.LanguageRepository;
import com.bolsaempleo.backend.app.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final ProfessionalRepository professionalRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository, ProfessionalRepository professionalRepository) {
        this.languageRepository = languageRepository;
        this.professionalRepository = professionalRepository;
    }

    @Override
    public List<LanguageResponseDto> findAll() {
        List<Language> languages = languageRepository.findAllByDeletedAtIsNull();
        return languages.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageResponseDto findById(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findByIdAndDeletedAtIsNull(id);
        return optionalLanguage.map(this::convertToResponseDTO).orElse(null);
    }

    @Override
    public LanguageResponseDto save(LanguageDto languageDto) {
        Language language = convertToEntity(languageDto);
        language.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Language savedLanguage = languageRepository.save(language);
        return convertToResponseDTO(savedLanguage);
    }

    @Override
    public LanguageResponseDto updateLanguage(Long id, LanguageDto languageDto) {
        Optional<Language> optionalLanguage = languageRepository.findByIdAndDeletedAtIsNull(id);
        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
            language = updateEntity(language, languageDto);
            language.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            Language updatedLanguage = languageRepository.save(language);
            return convertToResponseDTO(updatedLanguage);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
            language.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            languageRepository.save(language);
        }
    }

    private Language convertToEntity(LanguageDto dto) {
        Language language = new Language();
        language.setIdiomId(dto.getIdiomId());
        language.setReadLevelId(dto.getReadLevelId());
        language.setSpokenLevelId(dto.getSpokenLevelId());
        language.setWrittenLevelId(dto.getWrittenLevelId());
        Optional<Professional> professional = professionalRepository.findById(dto.getProfessionalId());
        professional.ifPresent(language::setProfessional);
        return language;
    }

    private Language updateEntity(Language language, LanguageDto dto) {
        language.setIdiomId(dto.getIdiomId());
        language.setReadLevelId(dto.getReadLevelId());
        language.setSpokenLevelId(dto.getSpokenLevelId());
        language.setWrittenLevelId(dto.getWrittenLevelId());
        Optional<Professional> professional = professionalRepository.findById(dto.getProfessionalId());
        professional.ifPresent(language::setProfessional);
        return language;
    }

    private LanguageResponseDto convertToResponseDTO(Language language) {
        LanguageResponseDto dto = new LanguageResponseDto();
        dto.setId(language.getId());
        dto.setIdiomId(language.getIdiomId());
        dto.setReadLevelId(language.getReadLevelId());
        dto.setSpokenLevelId(language.getSpokenLevelId());
        dto.setWrittenLevelId(language.getWrittenLevelId());
        dto.setProfessionalId(language.getProfessional().getId());
        dto.setCreatedAt(language.getCreatedAt());
        dto.setUpdatedAt(language.getUpdatedAt());
        return dto;
    }
}
