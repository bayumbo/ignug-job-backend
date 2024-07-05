package com.bolsaempleo.backend.app.dto;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto implements Serializable{


    private String avatar;
    private String birthdate;
    private String bloodTypeId;
    private String civilStatusId;
    private String createdAt;
    private String deletedAt;
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
    private String updatedAt;
    private String username;
    private String password;
}
