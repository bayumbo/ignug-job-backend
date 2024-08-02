package com.bolsaempleo.backend.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionalUserDto {

    private UsersDto usersDto;
    private ProfessionalDto professionalDto;
    //user
    /* 
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
    private String createdAtU;
    */
//profesional
/* 
    private String aboutMe;
    private boolean catastrophicDiseased;
    private boolean familiarCatastrophicDiseased;
    private boolean familiarDisabled;
    private String identificationFamiliarDisabled;
    private boolean traveled;
    private boolean disabled;
    private Timestamp createdAtP;
    private Timestamp updatedAt;

[
	{
		"userName":"1717675902",
		"password":"1717675902",
		"lastName":"GARCIA",
		"name":"EDUARDO",
		"avatar":"NADA",
		"birthdate":"",
		"email":"egarcia.sips@gmail.com",
		"emailVerifiedAt":"2021-11-30 19:20:00.0",
		"maxAttempts":"3",
		"passwordChanged":"false",
		"phone":"0998606656",
		"rememberToken":"",
		"sexId":"1",
		"ethnicOriginId":"1",
		"genderId":"1",
		"identificationTypeId":"1",
		"bloodTypeId":"1",
		"civilStatusId":"1",
		"createdAt":"2021-11-30 19:20:00.0",
		"updatedAt":"2021-11-30 19:20:00.0",
		"deletedAt":null
		},
	{
		"aboutMe":"ESTO ES UNA PRUEBA DE FUNCIONALIDAD",
		"catastrophicDiseased":"true",
		"createdAt":"2021-11-30 19:20:00.0",
		"deletedAt":null,
		"disabled":"true",
		"familiarCatastrophicDiseased":"true",
		"familiarDisabled":"true",
		"identificationFamiliarDisabled":"true",
		"traveled":"true",
		"updatedAt":"2021-11-30 19:20:00.0",
	}
]
        */
}
