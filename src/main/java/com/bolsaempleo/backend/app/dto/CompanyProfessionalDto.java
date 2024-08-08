package com.bolsaempleo.backend.app.dto;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import com.bolsaempleo.backend.app.entities.job_board.Company;
import com.bolsaempleo.backend.app.entities.job_board.Professional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyProfessionalDto implements Serializable{

 
    private Timestamp createdAt;
	private Long stateId;
	private Timestamp updatedAt;
	private UUID companyId;
	private UUID professionalId;
}
