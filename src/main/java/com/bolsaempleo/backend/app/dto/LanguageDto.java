package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LanguageDto {
    
    private Long idiomId;
    private Long readLevelId;
    private Long spokenLevelId;
    private Long writtenLevelId;
    private Long professionalId;

}
