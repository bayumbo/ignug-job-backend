package com.bolsaempleo.backend.app.entities.core;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the phones database table.
 * 
 */
@Entity
@Table(name="phones",schema = "core")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String number;

	@Column(name="phoneable_id")
	private Long phoneableId;

	@Column(name="phoneable_type")
	private String phoneableType;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne
	@JoinColumn(name="operator_id")
	private Catalogue catalogue1;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne
	@JoinColumn(name="type_id")
	private Catalogue catalogue2;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	public Phone() {
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

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getPhoneableId() {
		return this.phoneableId;
	}

	public void setPhoneableId(Long phoneableId) {
		this.phoneableId = phoneableId;
	}

	public String getPhoneableType() {
		return this.phoneableType;
	}

	public void setPhoneableType(String phoneableType) {
		this.phoneableType = phoneableType;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
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

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}