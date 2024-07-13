package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the courses database table.
 * 
 */
@Entity
@Table(name="courses",schema = "job_board")
@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name="certification_type_id", nullable=false)
	private Long certificationTypeId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(length=2147483647)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="ended_at", nullable=false)
	private Date endedAt;

	@Column(nullable=false)
	private Integer hours;

	@Column(nullable=false, length=255)
	private String institution;

	@Column(nullable=false, length=2147483647)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="started_at", nullable=false)
	private Date startedAt;

	@Column(name="type_id", nullable=false)
	private Long typeId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="area_id", nullable=false)
	private Category category;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="professional_id", nullable=false)
	private Professional professional;

	public Cours() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getCertificationTypeId() {
		return this.certificationTypeId;
	}

	public void setCertificationTypeId(Long certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndedAt() {
		return this.endedAt;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartedAt() {
		return this.startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}