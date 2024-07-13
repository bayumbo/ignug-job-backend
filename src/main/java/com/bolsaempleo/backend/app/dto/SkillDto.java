package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillDto implements Serializable{

    private String description;
    private Long typeId;
    private UUID professionalId;

}
