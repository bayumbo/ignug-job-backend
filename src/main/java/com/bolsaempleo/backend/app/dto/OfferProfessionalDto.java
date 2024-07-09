package com.bolsaempleo.backend.app.dto;

import java.sql.Timestamp;

import com.bolsaempleo.backend.app.entities.job_board.Offer;
import com.bolsaempleo.backend.app.entities.job_board.Professional;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OfferProfessionalDto {

	private Timestamp createdAt;
	private Long stateId;
	private Timestamp updatedAt;
	private Offer offer;
	private Professional professional;
}
