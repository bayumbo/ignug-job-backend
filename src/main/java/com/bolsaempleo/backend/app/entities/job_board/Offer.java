package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the offers database table.
 * 
 */
@Entity
@Table(name="offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Object activities;

	@Column(name="additional_information")
	private String additionalInformation;

	private String code;

	@Column(name="contact_cellphone")
	private String contactCellphone;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_phone")
	private String contactPhone;

	@Column(name="contract_type_id")
	private Long contractTypeId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Temporal(TemporalType.DATE)
	@Column(name="ended_at")
	private Date endedAt;

	@Column(name="experience_time_id")
	private Long experienceTimeId;

	@Column(name="location_id")
	private Long locationId;

	private String position;

	private String remuneration;

	private Object requirements;

	@Column(name="sector_id")
	private Long sectorId;

	@Temporal(TemporalType.DATE)
	@Column(name="started_at")
	private Date startedAt;

	@Column(name="state_id")
	private Long stateId;

	@Column(name="training_hours_id")
	private Long trainingHoursId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer vacancies;

	@Column(name="working_day_id")
	private Long workingDayId;

	//bi-directional many-to-one association to CategoryOffer
	@OneToMany(mappedBy="offer")
	private List<CategoryOffer> categoryOffers;

	//bi-directional many-to-one association to OfferProfessional
	@OneToMany(mappedBy="offer")
	private List<OfferProfessional> offerProfessionals;

	//bi-directional many-to-one association to Company
	@ManyToOne
	private Company company;

	public Offer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Object getActivities() {
		return this.activities;
	}

	public void setActivities(Object activities) {
		this.activities = activities;
	}

	public String getAdditionalInformation() {
		return this.additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContactCellphone() {
		return this.contactCellphone;
	}

	public void setContactCellphone(String contactCellphone) {
		this.contactCellphone = contactCellphone;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Long getContractTypeId() {
		return this.contractTypeId;
	}

	public void setContractTypeId(Long contractTypeId) {
		this.contractTypeId = contractTypeId;
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

	public Date getEndedAt() {
		return this.endedAt;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	public Long getExperienceTimeId() {
		return this.experienceTimeId;
	}

	public void setExperienceTimeId(Long experienceTimeId) {
		this.experienceTimeId = experienceTimeId;
	}

	public Long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRemuneration() {
		return this.remuneration;
	}

	public void setRemuneration(String remuneration) {
		this.remuneration = remuneration;
	}

	public Object getRequirements() {
		return this.requirements;
	}

	public void setRequirements(Object requirements) {
		this.requirements = requirements;
	}

	public Long getSectorId() {
		return this.sectorId;
	}

	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
	}

	public Date getStartedAt() {
		return this.startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getTrainingHoursId() {
		return this.trainingHoursId;
	}

	public void setTrainingHoursId(Long trainingHoursId) {
		this.trainingHoursId = trainingHoursId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getVacancies() {
		return this.vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public Long getWorkingDayId() {
		return this.workingDayId;
	}

	public void setWorkingDayId(Long workingDayId) {
		this.workingDayId = workingDayId;
	}

	public List<CategoryOffer> getCategoryOffers() {
		return this.categoryOffers;
	}

	public void setCategoryOffers(List<CategoryOffer> categoryOffers) {
		this.categoryOffers = categoryOffers;
	}

	public CategoryOffer addCategoryOffer(CategoryOffer categoryOffer) {
		getCategoryOffers().add(categoryOffer);
		categoryOffer.setOffer(this);

		return categoryOffer;
	}

	public CategoryOffer removeCategoryOffer(CategoryOffer categoryOffer) {
		getCategoryOffers().remove(categoryOffer);
		categoryOffer.setOffer(null);

		return categoryOffer;
	}

	public List<OfferProfessional> getOfferProfessionals() {
		return this.offerProfessionals;
	}

	public void setOfferProfessionals(List<OfferProfessional> offerProfessionals) {
		this.offerProfessionals = offerProfessionals;
	}

	public OfferProfessional addOfferProfessional(OfferProfessional offerProfessional) {
		getOfferProfessionals().add(offerProfessional);
		offerProfessional.setOffer(this);

		return offerProfessional;
	}

	public OfferProfessional removeOfferProfessional(OfferProfessional offerProfessional) {
		getOfferProfessionals().remove(offerProfessional);
		offerProfessional.setOffer(null);

		return offerProfessional;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}