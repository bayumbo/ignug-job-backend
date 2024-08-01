package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import com.bolsaempleo.backend.app.entities.job_board.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDto implements Serializable {


	private String activities;
	private String additionalInformation;
	private String code;
	private String contactCellphone;
	private String contactEmail;
	private String contactName;
	private String contactPhone;
	private Long contractTypeId;
	private Timestamp createdAt;
	private Timestamp deletedAt;
	private Date endedAt;
	private Long experienceTimeId;
	private Long locationId;
	private String position;
	private String remuneration;
	private String requirements;
	private Long sectorId;
	private Date startedAt;
	private Long stateId;
	private Long trainingHoursId;
	private Timestamp updatedAt;
	private Integer vacancies;
	private Long workingDayId;
	private UUID companyId; 
}
