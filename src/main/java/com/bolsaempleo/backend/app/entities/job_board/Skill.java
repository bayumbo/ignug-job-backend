package com.bolsaempleo.backend.app.entities.job_board;


import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the skills database table.
 * 
 */
@Entity
@Table(name="skills",schema = "job_board")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String description;

	@Column(name="type_id")
	private Long typeId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	private Professional professional;

	public Skill() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}