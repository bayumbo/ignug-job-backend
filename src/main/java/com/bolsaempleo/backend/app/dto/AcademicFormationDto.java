package com.bolsaempleo.backend.app.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicFormationDto {
    private Long id;
    private Long careerId;
    private Boolean certificated;
    private Date registeredAt;
    private String senescytCode;
    private Long categoryId;
    private Long professionalId;

}
