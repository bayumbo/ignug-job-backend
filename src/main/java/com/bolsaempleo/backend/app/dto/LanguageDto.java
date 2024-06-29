package com.bolsaempleo.backend.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.bolsaempleo.backend.app.entities.job_board.Language;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class LanguageDto {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdAt;
    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp deletedAt;
    @Getter
    @Setter
    private Long idiomId;
    @Getter
    @Setter
    private Long readLevelId;
    @Getter
    @Setter
    private Long spokenLevelId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updatedAt;
    @Getter
    @Setter
    private Long writtenLevelId;
    @Getter
    @Setter
    private Long professionalId;

    public LanguageDto() {

    }

    public LanguageDto(Language language) {
        this.id = language.getId();
        this.createdAt = language.getCreatedAt();
        this.deletedAt = language.getDeletedAt();
        this.idiomId = language.getIdiomId();
        this.readLevelId = language.getReadLevelId();
        this.spokenLevelId = language.getSpokenLevelId();
        this.updatedAt = language.getUpdatedAt();
        this.writtenLevelId = language.getWrittenLevelId();
        if (language.getProfessional() != null) {
            this.professionalId = language.getProfessional().getId();
        }
    }
}
