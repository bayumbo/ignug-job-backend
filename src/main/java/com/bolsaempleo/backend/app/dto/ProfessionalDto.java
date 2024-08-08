package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProfessionalDto implements Serializable{


    private String aboutMe;
	private Boolean catastrophicDiseased;
	private Timestamp createdAt;
	private Timestamp deletedAt;
	private Boolean disabled;
	private Boolean familiarCatastrophicDiseased;
	private Boolean familiarDisabled;
	private String identificationFamiliarDisabled;
	private Boolean traveled;
	private Timestamp updatedAt;
 
}