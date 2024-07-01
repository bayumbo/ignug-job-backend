package com.bolsaempleo.backend.app.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceResponseDto {
    private String code;
    private String message;
    private ExperienceDto experienceDto;

}