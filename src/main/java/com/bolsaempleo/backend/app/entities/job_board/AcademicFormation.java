package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the academic_formations database table.
 * 
 */
@Entity
@Table(name="academic_formations",schema = "job_board")
@NamedQuery(name="AcademicFormation.findAll", query="SELECT a FROM AcademicFormation a")
public class AcademicFormation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@SuppressWarnings("deprecation")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name="career_id", nullable=false)
	private Long careerId;

	@Column(nullable=false)
	private Boolean certificated;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Temporal(TemporalType.DATE)
	@Column(name="registered_at")
	private Date registeredAt;

	@Column(name="senescyt_code", length=255)
	private String senescytCode;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="professional_degree_id", nullable=false)
	private Category category;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="professional_id", nullable=false)
	private Professional professional;

	public AcademicFormation() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getCareerId() {
		return this.careerId;
	}

	public void setCareerId(Long careerId) {
		this.careerId = careerId;
	}

	public Boolean getCertificated() {
		return this.certificated;
	}

	public void setCertificated(Boolean certificated) {
		this.certificated = certificated;
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

	public Date getRegisteredAt() {
		return this.registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public String getSenescytCode() {
		return this.senescytCode;
	}

	public void setSenescytCode(String senescytCode) {
		this.senescytCode = senescytCode;
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