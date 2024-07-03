package com.bolsaempleo.backend.app.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageResponseDto {

    private Long id;
    private Long idiomId;
    private Long readLevelId;
    private Long spokenLevelId;
    private Long writtenLevelId;
    private Long professionalId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
