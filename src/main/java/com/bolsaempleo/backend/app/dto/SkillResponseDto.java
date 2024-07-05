package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillResponseDto implements Serializable{

    private Long id;
    private String description;
    private Long typeId;
    private Long professionalId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
