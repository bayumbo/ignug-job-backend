package com.bolsaempleo.backend.app.dto;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto implements Serializable{

	private String avatar;
	private Date birthdate;
	private Long bloodTypeId;
	private Long civilStatusId;
	private Timestamp createdAt;
	private Timestamp deletedAt;
	private String email;
	private Timestamp emailVerifiedAt;
	private Long ethnicOriginId;
	private Long genderId;
	private Long identificationTypeId;
	private String lastname;
	private Integer maxAttempts;
	private String name;
	private String password;
	private Boolean passwordChanged;
	private String phone;
	private String rememberToken;
	private Long sexId;
	private Timestamp updatedAt;
	private String username;
}
