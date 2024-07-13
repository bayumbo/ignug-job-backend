package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies",schema = "job_board")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;


	@Column(name="activity_type_id", nullable=false)
	private Long activityTypeId;

	@Column(name="commercial_activities", length=1000)
	private String commercialActivities;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(name="person_type_id", nullable=false)
	private Long personTypeId;

	@Column(name="trade_name", nullable=false, length=2147483647)
	private String tradeName;

	@Column(name="type_id", nullable=false)
	private Long typeId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="user_id", nullable=false)
	private Long userId;

	@Column(length=255)
	private String web;

	//bi-directional many-to-one association to CompanyProfessional
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private List<CompanyProfessional> companyProfessionals;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private List<Offer> offers;

	public Company() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getActivityTypeId() {
		return this.activityTypeId;
	}

	public void setActivityTypeId(Long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public String getCommercialActivities() {
		return this.commercialActivities;
	}

	public void setCommercialActivities(String commercialActivities) {
		this.commercialActivities = commercialActivities;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Long getPersonTypeId() {
		return this.personTypeId;
	}

	public void setPersonTypeId(Long personTypeId) {
		this.personTypeId = personTypeId;
	}

	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public List<CompanyProfessional> getCompanyProfessionals() {
		return this.companyProfessionals;
	}

	public void setCompanyProfessionals(List<CompanyProfessional> companyProfessionals) {
		this.companyProfessionals = companyProfessionals;
	}

	public CompanyProfessional addCompanyProfessional(CompanyProfessional companyProfessional) {
		getCompanyProfessionals().add(companyProfessional);
		companyProfessional.setCompany(this);

		return companyProfessional;
	}

	public CompanyProfessional removeCompanyProfessional(CompanyProfessional companyProfessional) {
		getCompanyProfessionals().remove(companyProfessional);
		companyProfessional.setCompany(null);

		return companyProfessional;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setCompany(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setCompany(null);

		return offer;
	}

}