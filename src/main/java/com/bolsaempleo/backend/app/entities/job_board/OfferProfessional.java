package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the offer_professional database table.
 * 
 */
@Entity
@Table(name="offer_professional",schema = "job_board")
@NamedQuery(name="OfferProfessional.findAll", query="SELECT o FROM OfferProfessional o")
public class OfferProfessional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;


	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="state_id")
	private Long stateId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	@JoinColumn(name="offer_id", nullable=false)
	private Offer offer;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="professional_id", nullable=false)
	private Professional professional;

	public OfferProfessional() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}