package com.bolsaempleo.backend.app.entities.job_board;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the languages database table.
 * 
 */
@Entity
@Table(name="languages",schema = "job_board")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(name="idiom_id")
	private Long idiomId;

	@Column(name="read_level_id")
	private Long readLevelId;

	@Column(name="spoken_level_id")
	private Long spokenLevelId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="written_level_id")
	private Long writtenLevelId;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	private Professional professional;

	public Language() {
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

	public Long getIdiomId() {
		return this.idiomId;
	}

	public void setIdiomId(Long idiomId) {
		this.idiomId = idiomId;
	}

	public Long getReadLevelId() {
		return this.readLevelId;
	}

	public void setReadLevelId(Long readLevelId) {
		this.readLevelId = readLevelId;
	}

	public Long getSpokenLevelId() {
		return this.spokenLevelId;
	}

	public void setSpokenLevelId(Long spokenLevelId) {
		this.spokenLevelId = spokenLevelId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getWrittenLevelId() {
		return this.writtenLevelId;
	}

	public void setWrittenLevelId(Long writtenLevelId) {
		this.writtenLevelId = writtenLevelId;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}