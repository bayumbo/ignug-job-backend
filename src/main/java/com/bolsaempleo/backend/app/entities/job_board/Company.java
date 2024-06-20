package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies",schema = "job_board")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="activity_type_id")
	private Long activityTypeId;

	@Column(name="commercial_activities")
	private Object commercialActivities;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(name="person_type_id")
	private Long personTypeId;

	@Column(name="trade_name")
	private String tradeName;

	@Column(name="type_id")
	private Long typeId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="user_id")
	private Long userId;

	private String web;

	//bi-directional many-to-one association to CompanyProfessional
	@OneToMany(mappedBy="company")
	private List<CompanyProfessional> companyProfessionals;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="company")
	private List<Offer> offers;

	public Company() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityTypeId() {
		return this.activityTypeId;
	}

	public void setActivityTypeId(Long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public Object getCommercialActivities() {
		return this.commercialActivities;
	}

	public void setCommercialActivities(Object commercialActivities) {
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