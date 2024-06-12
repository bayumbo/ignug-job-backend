package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

public class ProfessionalDto {

    @Getter
    @Setter
    private String createdAt;
    @Getter
    @Setter
    private String updatedAt;
    @Getter
    @Setter
    private String deletedAt;
    @Getter
    @Setter
    private String aboutMe;
    @Getter
    @Setter
    private boolean catastrophicDiseased;
    @Getter
    @Setter
    private boolean familiarCatastrophicDiseased;
    @Getter
    @Setter
    private boolean familiarDisabled;
    @Getter
    @Setter
    private String identificationFamiliarDisabled;
    @Getter
    @Setter
    private boolean traveled;



    
}