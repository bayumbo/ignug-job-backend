package com.bolsaempleo.backend.app.entities.core;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the careers database table.
 * 
 */
@Entity
@Table(name="careers",schema = "core")
@NamedQuery(name="Career.findAll", query="SELECT c FROM Career c")
public class Career implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String acronym;

	private String code;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String description;

	private String logo;

	private String name;

	@Column(name="resolution_number")
	private String resolutionNumber;

	@Column(name="short_name")
	private String shortName;

	private String title;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	private Institution institution;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne
	@JoinColumn(name="modality_id")
	private Catalogue catalogue1;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne
	@JoinColumn(name="type_id")
	private Catalogue catalogue2;

	public Career() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResolutionNumber() {
		return this.resolutionNumber;
	}

	public void setResolutionNumber(String resolutionNumber) {
		this.resolutionNumber = resolutionNumber;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Catalogue getCatalogue1() {
		return this.catalogue1;
	}

	public void setCatalogue1(Catalogue catalogue1) {
		this.catalogue1 = catalogue1;
	}

	public Catalogue getCatalogue2() {
		return this.catalogue2;
	}

	public void setCatalogue2(Catalogue catalogue2) {
		this.catalogue2 = catalogue2;
	}

}