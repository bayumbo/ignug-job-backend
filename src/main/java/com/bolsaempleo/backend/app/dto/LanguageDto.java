package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LanguageDto implements Serializable{
    
    private Long idiomId;
    private Long readLevelId;
    private Long spokenLevelId;
    private Long writtenLevelId;
    private UUID professionalId;

}
