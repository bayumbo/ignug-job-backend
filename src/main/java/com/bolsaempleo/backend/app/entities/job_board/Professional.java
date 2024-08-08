package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the professionals database table.
 * 
 */
@Entity
@Table(name="professionals",schema = "job_board")
@NamedQuery(name="Professional.findAll", query="SELECT p FROM Professional p")
public class Professional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name="about_me", length=2147483647)
	private String aboutMe;

	@Column(name="catastrophic_diseased", nullable=false)
	private Boolean catastrophicDiseased;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(nullable=false)
	private Boolean disabled;

	@Column(name="familiar_catastrophic_diseased", nullable=false)
	private Boolean familiarCatastrophicDiseased;

	@Column(name="familiar_disabled", nullable=false)
	private Boolean familiarDisabled;

	@Column(name="identification_familiar_disabled", length=255)
	private String identificationFamiliarDisabled;

	@Column(nullable=false)
	private Boolean traveled;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="user_id", nullable=false)
	private UUID userId;

	//bi-directional many-to-one association to AcademicFormation
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<AcademicFormation> academicFormations;

	//bi-directional many-to-one association to CompanyProfessional
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<CompanyProfessional> companyProfessionals;

	//bi-directional many-to-one association to Cours
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<Cours> courses;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<Experience> experiences;

	//bi-directional many-to-one association to Language
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<Language> languages;

	//bi-directional many-to-one association to OfferProfessional
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<OfferProfessional> offerProfessionals;

	//bi-directional many-to-one association to Reference
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<Reference> references;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="professional", fetch=FetchType.EAGER)
	private List<Skill> skills;

	public Professional() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAboutMe() {
		return this.aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Boolean getCatastrophicDiseased() {
		return this.catastrophicDiseased;
	}

	public void setCatastrophicDiseased(Boolean catastrophicDiseased) {
		this.catastrophicDiseased = catastrophicDiseased;
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

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getFamiliarCatastrophicDiseased() {
		return this.familiarCatastrophicDiseased;
	}

	public void setFamiliarCatastrophicDiseased(Boolean familiarCatastrophicDiseased) {
		this.familiarCatastrophicDiseased = familiarCatastrophicDiseased;
	}

	public Boolean getFamiliarDisabled() {
		return this.familiarDisabled;
	}

	public void setFamiliarDisabled(Boolean familiarDisabled) {
		this.familiarDisabled = familiarDisabled;
	}

	public String getIdentificationFamiliarDisabled() {
		return this.identificationFamiliarDisabled;
	}

	public void setIdentificationFamiliarDisabled(String identificationFamiliarDisabled) {
		this.identificationFamiliarDisabled = identificationFamiliarDisabled;
	}

	public Boolean getTraveled() {
		return this.traveled;
	}

	public void setTraveled(Boolean traveled) {
		this.traveled = traveled;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public List<AcademicFormation> getAcademicFormations() {
		return this.academicFormations;
	}

	public void setAcademicFormations(List<AcademicFormation> academicFormations) {
		this.academicFormations = academicFormations;
	}

	public AcademicFormation addAcademicFormation(AcademicFormation academicFormation) {
		getAcademicFormations().add(academicFormation);
		academicFormation.setProfessional(this);

		return academicFormation;
	}

	public AcademicFormation removeAcademicFormation(AcademicFormation academicFormation) {
		getAcademicFormations().remove(academicFormation);
		academicFormation.setProfessional(null);

		return academicFormation;
	}

	public List<CompanyProfessional> getCompanyProfessionals() {
		return this.companyProfessionals;
	}

	public void setCompanyProfessionals(List<CompanyProfessional> companyProfessionals) {
		this.companyProfessionals = companyProfessionals;
	}

	public CompanyProfessional addCompanyProfessional(CompanyProfessional companyProfessional) {
		getCompanyProfessionals().add(companyProfessional);
		companyProfessional.setProfessional(this);

		return companyProfessional;
	}

	public CompanyProfessional removeCompanyProfessional(CompanyProfessional companyProfessional) {
		getCompanyProfessionals().remove(companyProfessional);
		companyProfessional.setProfessional(null);

		return companyProfessional;
	}

	public List<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}

	public Cours addCours(Cours cours) {
		getCourses().add(cours);
		cours.setProfessional(this);

		return cours;
	}

	public Cours removeCours(Cours cours) {
		getCourses().remove(cours);
		cours.setProfessional(null);

		return cours;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setProfessional(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setProfessional(null);

		return experience;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language addLanguage(Language language) {
		getLanguages().add(language);
		language.setProfessional(this);

		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		language.setProfessional(null);

		return language;
	}

	public List<OfferProfessional> getOfferProfessionals() {
		return this.offerProfessionals;
	}

	public void setOfferProfessionals(List<OfferProfessional> offerProfessionals) {
		this.offerProfessionals = offerProfessionals;
	}

	public OfferProfessional addOfferProfessional(OfferProfessional offerProfessional) {
		getOfferProfessionals().add(offerProfessional);
		offerProfessional.setProfessional(this);

		return offerProfessional;
	}

	public OfferProfessional removeOfferProfessional(OfferProfessional offerProfessional) {
		getOfferProfessionals().remove(offerProfessional);
		offerProfessional.setProfessional(null);

		return offerProfessional;
	}

	public List<Reference> getReferences() {
		return this.references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	public Reference addReference(Reference reference) {
		getReferences().add(reference);
		reference.setProfessional(this);

		return reference;
	}

	public Reference removeReference(Reference reference) {
		getReferences().remove(reference);
		reference.setProfessional(null);

		return reference;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setProfessional(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setProfessional(null);

		return skill;
	}

}