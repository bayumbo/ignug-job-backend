package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProfessionalDto {


    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String aboutMe;
    private boolean catastrophicDiseased;
    private boolean familiarCatastrophicDiseased;
    private boolean familiarDisabled;
    private String identificationFamiliarDisabled;
    private boolean traveled;
 
}