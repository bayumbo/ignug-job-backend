package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageResponseDto implements Serializable{

    private UUID id;
    private Long idiomId;
    private Long readLevelId;
    private Long spokenLevelId;
    private Long writtenLevelId;
    private UUID professionalId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
