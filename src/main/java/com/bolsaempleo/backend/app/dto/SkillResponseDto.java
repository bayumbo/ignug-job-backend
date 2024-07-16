package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillResponseDto implements Serializable{

    private UUID id;
    private String description;
    private Long typeId;
    private UUID professionalId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
