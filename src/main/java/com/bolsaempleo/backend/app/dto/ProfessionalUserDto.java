package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionalUserDto {

    //user
    private String username;
    private String password;
    private String avatar;
    private String birthdate;
    private String bloodTypeId;
    private String civilStatusId;
    private String email;
    private String emailVerifiedAt;
    private String ethnicOriginId;
    private String genderId;
    private String identificationTypeId;
    private String lastname;
    private String maxAttempts;
    private String name;
    private String passwordChanged;
    private String phone;
    private String rememberToken;
    private String sexId;

//profesional
    private String aboutMe;
    private boolean catastrophicDiseased;
    private boolean familiarCatastrophicDiseased;
    private boolean familiarDisabled;
    private String identificationFamiliarDisabled;
    private boolean traveled;
    private String createdAt;
    private String updatedAt;
}
