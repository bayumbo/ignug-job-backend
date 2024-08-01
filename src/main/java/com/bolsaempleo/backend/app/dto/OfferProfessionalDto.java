package com.bolsaempleo.backend.app.dto;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OfferProfessionalDto {

	private Timestamp createdAt;
	private Long stateId;
	private Timestamp updatedAt;
	private UUID offerId;
	private UUID professionalId;
}
