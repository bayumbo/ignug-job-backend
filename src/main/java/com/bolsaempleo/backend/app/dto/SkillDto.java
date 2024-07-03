package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillDto {

    private String description;
    private Long typeId;
    private Long professionalId;

}
